package com.atm.webapi.service;

import com.atm.data.entity.CardEntity;
import com.atm.data.entity.Status;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.mapper.ClientInfoMapper;
import com.atm.domain.service.CardService;
import com.atm.domain.util.DateUtil;
import com.atm.domain.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Imant on 19.06.17.
 */
@Service
public class OperationsWebService {

    @Autowired
    CardService cardService;

    private static final int FINAL_PASSWORD_COUNTER = 4;

    public ModelAndView operationsMenu(Map<String, ?> map, ClientInfoDto client) {
        if (map != null) {
            if (!client.isFullAccess()) {
                String encodeNumber = EncryptionUtil.encode(client.getNumber());
                if (client.getPasswordCounter() >= FINAL_PASSWORD_COUNTER) {
                    CardEntity cardEntity = cardService.findCardByNumber(encodeNumber);
                    cardEntity.setStatus(Status.BLOCKED);
                    cardService.update(cardEntity);
                    client.setPasswordCounter(0);
                    client.setNumber(null);
                    client.setPassword(null);
                    return new ModelAndView("card_blocked", "errorMassage", ErrorStatus.BLOCKED_CARD.getMassage());
                }
                List cardList = cardService.findCardByNumberAndPassword(client);
                if (cardList.isEmpty()) {
                    client.setPassword(null);
                    client.setPasswordCounter(client.getPasswordCounter() + 1);
                    return new ModelAndView("card_pin_code_entry_error", "errorMassage", ErrorStatus.WRONG_CARD_PIN_CODE.getMassage());
                } else {
                    CardEntity card = (CardEntity) cardList.get(0);
                    ClientInfoMapper.convertCardEntityToClientDto(card, client);
                }
            }
            return new ModelAndView("card_operations");
        } else return new ModelAndView("redirect:/");
    }

    public ModelAndView showBalance(Map<String, ?> map, ClientInfoDto client) {
        if (map != null) {
            client.setDate(DateUtil.getCurrentDate());
            return new ModelAndView("account_balance", "client", client);
        } else return new ModelAndView("redirect:/");
    }

    public String withdrawMoney(Map<String, ?> map, ClientInfoDto client) {
        if (map != null) {
            client.setWithdrawAmount(null);
            return "card_withdraw_money";
        } else return "redirect:/";
    }
}
