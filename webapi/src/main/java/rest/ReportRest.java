package rest;

import dto.CardInfoDto;
import dto.ReportInfoDto;
import dto.errorEnum.ErrorStatus;
import entity.CardEntity;
import entity.ReportEntity;
import mapper.CardInfoMapper;
import mapper.ReportInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CardService;
import service.ReportService;
import util.DateService;

/**
 * Created by Imant on 27.05.17.
 */
@Controller
public class ReportRest {

    @Autowired
    private ReportService reportService;
    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/operation/report", method = RequestMethod.POST)
    public ModelAndView getReport(@ModelAttribute("card") CardInfoDto cardInfo, @ModelAttribute("amountToRemove") Integer amountToRemove) {
        if (amountToRemove > cardInfo.getBalance())
            return new ModelAndView("errorPage", "error", ErrorStatus.WRONG_AMOUNT_OF_MONEY_TO_REMOVE);

        int newBalance = cardInfo.getBalance() - amountToRemove;
        cardInfo.setBalance(newBalance);

        CardEntity cardEntity = cardService.find(cardInfo.getCardNumber());
        cardEntity.setBalance(newBalance);
        cardService.update(cardEntity);

        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setCardEntity(cardEntity);
        reportEntity.setDate(DateService.getCurrentDate());
        reportEntity.setAmountWithdraw(amountToRemove);
        reportEntity.setBalance(newBalance);
        reportService.save(reportEntity);
        ReportInfoDto reportInfo = ReportInfoMapper.convertToReportInfoDto(reportEntity);
        return new ModelAndView("reportPage", "card", reportInfo);
    }
}
