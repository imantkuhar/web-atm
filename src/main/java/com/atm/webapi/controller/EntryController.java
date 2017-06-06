package com.atm.webapi.controller;

import com.atm.data.entity.CardEntity;
import com.atm.data.entity.Status;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.mapper.ClientInfoMapper;
import com.atm.domain.service.AccountEntityService;
import com.atm.domain.service.CardEntityService;
import com.atm.domain.service.ReportEntityService;
import com.atm.domain.util.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class EntryController {

    @Autowired
    private AccountEntityService accountService;
    @Autowired
    private CardEntityService cardService;
    @Autowired
    ReportEntityService reportService;

    private static final Integer PASSWORD_COUNTER = 4;
    private static final String NEW_CLIENT_PASSWORD = "";

    @RequestMapping(value = "/number-entry")
    public String game() {
        return "numberEntry";
    }

    @RequestMapping(value = "/pin-code-entry", method = RequestMethod.GET)
    public ModelAndView cardNumberEntry(@ModelAttribute("cardNumber") String cardNumber) {
        String number = EncryptionService.encode(cardNumber);
        CardEntity card = cardService.findCardByNumber(number);
        if (card.getStatus() == Status.BLOCKED) {
            return new ModelAndView("blockedCard", "errorMassage", ErrorStatus.BLOCKED_CARD.getMassage());
        }
        ClientInfoDto client = ClientInfoMapper.convertToClientDto(card);
        return new ModelAndView("pinCodeEntry", "client", client);
    }

    @RequestMapping(value = "/operations")
    public ModelAndView pinCodeEntry(@ModelAttribute("client") ClientInfoDto client,
                                     @ModelAttribute("cardPassword") String cardPassword) {
        String password = EncryptionService.encode(cardPassword);
        Integer counter = client.getPasswordCounter();
        if (counter == PASSWORD_COUNTER) {
            CardEntity card = cardService.findById(client.getId());
            card.setStatus(Status.BLOCKED);
            cardService.update(card);
            return new ModelAndView("blockedCard", "errorMassage", ErrorStatus.BLOCKED_CARD.getMassage());
        } else if (!client.getPassword().equals(password)) {
            counter++;
            client.setPasswordCounter(counter);
            return new ModelAndView("error", "errorMassage", ErrorStatus.WRONG_CARD_PIN_CODE.getMassage());
        } else client.setPassword(NEW_CLIENT_PASSWORD);
        return new ModelAndView("operations", "client", client);
    }
}
