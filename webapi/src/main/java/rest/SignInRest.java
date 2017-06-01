package rest;


import dto.CardInfoDto;
import dto.errorEnum.ErrorStatus;
import entity.AccountEntity;
import entity.CardEntity;
import entity.Status;
import mapper.CardInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.CardRepository;
import service.CardService;
import util.EncryptionService;

/**
 * Created by Imant on 27.05.17.
 */
@Controller
public class SignInRest {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/pin-card-entry")
    public ModelAndView checkCardPin() {
        return new ModelAndView("mainPage", "cardNumber", new String());
    }

    @RequestMapping(value = "/id-card-entry", method = RequestMethod.GET)
    public ModelAndView checkCardId(@ModelAttribute("cardNumber") String cardNumber) {
        CardEntity card = cardService.find(EncryptionService.decode(cardNumber.getBytes()));
        if (card.getStatus() == Status.BLOCKED)
            return new ModelAndView("errorPage", "error", ErrorStatus.WRONG_CARD_NUMBER);
        CardInfoDto cardInfo = CardInfoMapper.convertToCardInfoDto(card);
        return new ModelAndView("entryPinCodePage", "card", cardInfo);
    }
}