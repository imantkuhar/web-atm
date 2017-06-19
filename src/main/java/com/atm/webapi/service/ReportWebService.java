package com.atm.webapi.service;

import com.atm.data.entity.CardEntity;
import com.atm.data.entity.ReportEntity;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.service.CardService;
import com.atm.domain.service.ReportService;
import com.atm.domain.util.DateUtil;
import com.atm.domain.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Imant on 19.06.17.
 */
@Service
public class ReportWebService {

    @Autowired
    CardService cardService;
    @Autowired
    ReportService reportService;

    public ModelAndView withdrawReport(Map<String, ?> map, ClientInfoDto client) {
        if (map != null) {
            Integer withdrawAmount = client.getWithdrawAmount();
            if (withdrawAmount == null || withdrawAmount == 0 || withdrawAmount > client.getBalance()) {
                return new ModelAndView("card_withdraw_money_error", "errorMassage", ErrorStatus.WRONG_AMOUNT_OF_MONEY_TO_REMOVE.getMassage());
            }
            Integer newBalance = client.getBalance() - withdrawAmount;
            CardEntity card = cardService.findCardByNumber(EncryptionUtil.encode(client.getNumber()));
            card.setBalance(newBalance);
            cardService.update(card);

            ReportEntity report = new ReportEntity(card, DateUtil.getCurrentDate(), withdrawAmount, newBalance);
            reportService.save(report);

            client.setBalance(newBalance);
            client.setDate(DateUtil.getCurrentDate());
            return new ModelAndView("account_report", "client", client);
        } else return new ModelAndView("redirect:/");
    }
}
