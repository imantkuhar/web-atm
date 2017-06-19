package com.atm.webapi.controller;

import com.atm.domain.dto.ClientInfoDto;
import com.atm.webapi.service.CardWebService;
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
public class CardController {

    @Autowired
    CardWebService cardWebService;

    @ModelAttribute("client")
    public ClientInfoDto createUser() {
        return new ClientInfoDto();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView cardNumberEntry(@ModelAttribute("client") ClientInfoDto client) {
        return new ModelAndView("card_number_entry", "client", new ClientInfoDto());
    }

    @RequestMapping(value = "/redirect-pin-code-entry", method = RequestMethod.POST)
    public ModelAndView redirectPinCodeEntry(@ModelAttribute("client") ClientInfoDto client,
                                             RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(client);
        return new ModelAndView("redirect:/pin-code-entry");
    }

    @RequestMapping(value = "/pin-code-entry", method = RequestMethod.GET)
    public ModelAndView pinCodeEntry(HttpServletRequest request, @ModelAttribute("client") ClientInfoDto client) {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
        ModelAndView model = cardWebService.pinCodeEntry(map, client);
        return model;
    }
}