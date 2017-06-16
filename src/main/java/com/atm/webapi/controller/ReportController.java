package com.atm.webapi.controller;

import com.atm.data.entity.CardEntity;
import com.atm.data.entity.ReportEntity;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.service.CardEntityService;
import com.atm.domain.service.ReportEntityService;
import com.atm.domain.util.DateUtil;
import com.atm.domain.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@SessionAttributes(value = "client")
public class ReportController {

    @Autowired
    CardEntityService cardService;
    @Autowired
    ReportEntityService reportService;

    @RequestMapping(value = "/redirect-report", method = RequestMethod.POST)
    public String redirectWithdrawReport(@ModelAttribute("client") ClientInfoDto client,
                                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return "redirect:/report";
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView withdrawReport(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            Integer removedAmount = client.getRemovedAmount();
            if (removedAmount == null || removedAmount == 0 || removedAmount > client.getBalance()) {
                return new ModelAndView("card_withdraw_money_error", "errorMassage", ErrorStatus.WRONG_AMOUNT_OF_MONEY_TO_REMOVE.getMassage());
            }
            Integer newBalance = client.getBalance() - removedAmount;
            CardEntity card = cardService.findCardByNumber(EncryptionUtil.encode(client.getNumber()));
            card.setBalance(newBalance);
            cardService.update(card);

            ReportEntity report = new ReportEntity(card, DateUtil.getCurrentDate(), removedAmount, newBalance);
            reportService.save(report);

            client.setBalance(newBalance);
            client.setDate(DateUtil.getCurrentDate());
            return new ModelAndView("account_report", "client", client);
        } else return new ModelAndView("redirect:/");
    }
}
