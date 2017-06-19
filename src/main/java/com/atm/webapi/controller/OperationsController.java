package com.atm.webapi.controller;

import com.atm.domain.dto.ClientInfoDto;
import com.atm.webapi.service.OperationsWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@SessionAttributes(value = "client")
public class OperationsController {

    @Autowired
    OperationsWebService operationsWebService;

    @RequestMapping(value = "/redirect-operations", method = RequestMethod.POST)
    public String redirectOperationsMenu(@ModelAttribute("client") ClientInfoDto client,
                                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return "redirect:/operations";
    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public ModelAndView operationsMenu(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        ModelAndView model = operationsWebService.operationsMenu(map, client);
        return model;
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
        ModelAndView model = operationsWebService.showBalance(map, client);
        return model;
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
        String model = operationsWebService.withdrawMoney(map, client);
        return model;
    }
}
