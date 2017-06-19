package com.atm.webapi.service;

import com.atm.data.entity.Status;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.service.CardService;
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
public class CardWebService {

    @Autowired
    CardService cardService;

    private static final int CARD_NUMBER_LENGTH = 4;

    public ModelAndView pinCodeEntry(Map<String, ?> map, ClientInfoDto client) {
        if (map != null) {
            if (!client.isConfirmedNumber()) {
                if (client.getNumber().length() != CARD_NUMBER_LENGTH) {
                    return new ModelAndView("card_number_entry_error", "errorMassage", ErrorStatus.WRONG_CARD_NUMBER.getMassage());
                }
                String encodeNumber = EncryptionUtil.encode(client.getNumber());
                List cardStatusList = cardService.getCardStatusByNumber(encodeNumber);
                if (cardStatusList.isEmpty()) {
                    return new ModelAndView("card_number_entry_error", "errorMassage", ErrorStatus.WRONG_CARD_NUMBER.getMassage());
                } else if (cardStatusList.get(0) == Status.BLOCKED) {
                    return new ModelAndView("card_blocked", "errorMassage", ErrorStatus.BLOCKED_CARD.getMassage());
                }
                client.setConfirmedNumber(true);
            }
            return new ModelAndView("card_pin_code_entry", "client", client);
        } else return new ModelAndView("redirect:/");
    }
}
