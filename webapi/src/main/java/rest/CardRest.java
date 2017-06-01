package rest;


import dto.CardInfoDto;
import entity.CardEntity;
import mapper.CardInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.CardRepository;
import service.CardService;

/**
 * Created by Imant on 27.05.17.
 */
@Controller
public class CardRest {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/operations", method = RequestMethod.POST)
    public ModelAndView chooseOperation(@ModelAttribute("card") CardInfoDto cardInfo) {
        return new ModelAndView("operationsPage", "card", cardInfo);
    }

    @RequestMapping(value = "/operations/balance", method = RequestMethod.GET)
    public ModelAndView getBalance(@ModelAttribute("card") CardInfoDto cardInfo) {
        return new ModelAndView("balancePage", "card", cardInfo);
    }

    @RequestMapping(value = "/operations/withdrawal", method = RequestMethod.GET)
    public ModelAndView getAmountOfMoney(@ModelAttribute("card") CardInfoDto cardInfo) {
        return new ModelAndView("withdrawalPage", "card", cardInfo);
    }
}