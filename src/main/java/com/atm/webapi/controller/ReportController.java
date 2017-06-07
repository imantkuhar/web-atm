package com.atm.webapi.controller;

import com.atm.data.entity.CardEntity;
import com.atm.data.entity.ReportEntity;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.service.CardEntityService;
import com.atm.domain.service.ReportEntityService;
import com.atm.domain.util.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Imant on 05.06.17.
 */

@Controller
@EnableAutoConfiguration
public class ReportController {

    @Autowired
    private CardEntityService cardService;
    @Autowired
    ReportEntityService reportService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ModelAndView withdrawReport(@ModelAttribute("client") ClientInfoDto client,
                                       @ModelAttribute("removedAmount") Integer removedAmount) {
        if (removedAmount == 0 || client.getBalance() < removedAmount) {
            return new ModelAndView("error", "errorMassage", ErrorStatus.WRONG_AMOUNT_OF_MONEY_TO_REMOVE.getMassage());
        }
        Integer newBalance = client.getBalance() - removedAmount;
        CardEntity card = cardService.findById(client.getId());
        card.setBalance(newBalance);
        cardService.update(card);

        ReportEntity report = new ReportEntity(card, DateService.getCurrentDate(), removedAmount, newBalance);
        reportService.save(report);

        client.setBalance(newBalance);
        client.setRemovedAmount(removedAmount);
        client.setCardNumber(card.getNumber());
        client.setDate(DateService.getCurrentDate());
        return new ModelAndView("report", "client", client);
    }

}
