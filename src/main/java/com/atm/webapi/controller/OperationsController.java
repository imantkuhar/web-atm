package com.atm.webapi.controller;

import com.atm.domain.dto.ClientInfoDto;
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
public class OperationsController {

    @Autowired
    private CardEntityService cardService;
    @Autowired
    ReportEntityService reportService;

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public ModelAndView showBalance(@ModelAttribute("client") ClientInfoDto client) {
        client.setDate(DateService.getCurrentDate());
        return new ModelAndView("balance", "client", client);
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public ModelAndView withdrawMoney(@ModelAttribute("client") ClientInfoDto client) {
        return new ModelAndView("withdrawMoney", "client", client);
    }
}
