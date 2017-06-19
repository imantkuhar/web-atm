package com.atm.webapi.controller;

import com.atm.domain.dto.ClientInfoDto;
import com.atm.webapi.service.ReportWebService;
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
    ReportWebService reportWebService;

    @RequestMapping(value = "/redirect-report", method = RequestMethod.POST)
    public String redirectWithdrawReport(@ModelAttribute("client") ClientInfoDto client,
                                         RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return "redirect:/report";
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public ModelAndView withdrawReport(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        ModelAndView model = reportWebService.withdrawReport(map, client);
        return model;
    }
}
