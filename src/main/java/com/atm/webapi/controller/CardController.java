package com.atm.webapi.controller;

import com.atm.data.entity.Status;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.dto.errorEnum.ErrorStatus;
import com.atm.domain.service.CardEntityService;
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
public class CardController {

    @Autowired
    CardEntityService cardService;

    private static final int CARD_NUMBER_LENGTH = 4;

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
        if (map != null) {
            if (!(client.getNumber().length() == CARD_NUMBER_LENGTH)) {
                return new ModelAndView("card_number_entry_error", "errorMassage", ErrorStatus.WRONG_CARD_NUMBER.getMassage());
            }
            String encodeNumber = EncryptionUtil.encode(client.getNumber());
            List cardList = cardService.getCardStatusByNumber(encodeNumber);
            if (cardList.isEmpty()) {
                return new ModelAndView("card_number_entry_error", "errorMassage", ErrorStatus.WRONG_CARD_NUMBER.getMassage());
            } else if (cardList.get(0) == Status.BLOCKED) {
                return new ModelAndView("card_blocked", "errorMassage", ErrorStatus.BLOCKED_CARD.getMassage());
            }
            return new ModelAndView("card_pin_code_entry", "client", client);
        } else return new ModelAndView("redirect:/");
    }
}