package com.atm.webapi;

import com.atm.data.entity.AccountEntity;
import com.atm.data.entity.CardEntity;
import com.atm.data.entity.ReportEntity;
import com.atm.data.entity.Status;
import com.atm.domain.service.AccountEntityService;
import com.atm.domain.service.CardEntityService;
import com.atm.domain.service.ReportEntityService;
import com.atm.domain.util.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class CardController {

    @Autowired
    private AccountEntityService accountService;
    @Autowired
    private CardEntityService cardService;
    @Autowired
    ReportEntityService reportService;

    @RequestMapping("/main")
    public String game() {
        AccountEntity account = new AccountEntity(0, "0", "0", "0");
        accountService.save(account);

        CardEntity cardEntity1 = new CardEntity("100", "100", 100, Status.FREE, account);
        cardService.save(cardEntity1);

        ReportEntity reportEntity1 = new ReportEntity(cardEntity1, DateService.getCurrentDate(), 10, 10);
        ReportEntity reportEntity2 = new ReportEntity(cardEntity1, DateService.getCurrentDate(), 20, 20);
        reportService.save(reportEntity1);
        reportService.save(reportEntity2);

        return "main";
    }
}
