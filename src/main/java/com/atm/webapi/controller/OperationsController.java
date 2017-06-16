package com.atm.webapi.controller;

import com.atm.data.entity.CardEntity;
import com.atm.data.entity.Status;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.mapper.ClientInfoMapper;
import com.atm.domain.service.CardEntityService;
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
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@SessionAttributes(value = "client")
public class OperationsController {

    @Autowired
    CardEntityService cardService;

    private static int passwordCounter = 0;
    private static final int FINAL_PASSWORD_COUNTER = 4;


    @RequestMapping(value = "/redirect-operations", method = RequestMethod.POST)
    public String redirectOperationsMenu(@ModelAttribute("client") ClientInfoDto client,
                                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return "redirect:/operations";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public ModelAndView operationsMenu(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            String encodeNumber = EncryptionUtil.encode(client.getNumber());
            if (passwordCounter >= FINAL_PASSWORD_COUNTER) {
                CardEntity cardEntity = cardService.findCardByNumber(encodeNumber);
                cardEntity.setStatus(Status.BLOCKED);
                cardService.update(cardEntity);
                passwordCounter = 0;
                client.setPassword(null);
                return new ModelAndView("card_blocked", "errorMassage", ErrorStatus.BLOCKED_CARD.getMassage());
            }
            List cardList = cardService.findCardByNumberAndPassword(client);
            if (cardList.isEmpty()) {
                client.setPassword(null);
                passwordCounter++;
                return new ModelAndView("card_pin_code_entry_error", "errorMassage", ErrorStatus.WRONG_CARD_PIN_CODE.getMassage());
            } else {
                CardEntity card = (CardEntity) cardList.get(0);
                ClientInfoMapper.convertCardEntityToClientDto(card, client);
                return new ModelAndView("card_operations");
            }
        } else return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/redirect-balance", method = RequestMethod.POST)
    public String redirectShowBalance(@ModelAttribute("client") ClientInfoDto client,
                                      RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return "redirect:/balance";
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public ModelAndView showBalance(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            client.setDate(DateUtil.getCurrentDate());
            return new ModelAndView("account_balance", "client", client);
        } else return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/redirect-withdraw", method = RequestMethod.POST)
    public String redirectWithdrawMoney(@ModelAttribute("client") ClientInfoDto client,
                                        RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return "redirect:/withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdrawMoney(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        if (map != null) {
            client.setRemovedAmount(null);
            return "card_withdraw_money";
        } else return "redirect:/";
    }
}
