package com.atm.webapi;

import com.atm.data.entity.AccountEntity;
import com.atm.data.entity.CardEntity;
import com.atm.domain.service.AccountEntityService;
import com.atm.domain.service.CardEntityService;
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

    @RequestMapping("/main")
    public String game() {
        AccountEntity account1 = new AccountEntity(101, "lol1", "lol1", "lol1");
        AccountEntity account2 = new AccountEntity(101, "lol2", "lol2", "lol2");
//        AccountEntity account3 = new AccountEntity(101, "lol3", "lol3", "lol3");
        accountService.save(account1);
        accountService.save(account2);
//        accountService.save(account3);
        System.out.println("accounts created");
        System.out.println();
        CardEntity cardEntity1 = new CardEntity();
        CardEntity cardEntity2 = new CardEntity();
//        CardEntity cardEntity3 = new CardEntity();
        cardEntity1.setAccountEntity(account1);
        cardEntity2.setAccountEntity(account2);
//        cardEntity3.setAccountEntity(account3);
        cardEntity1.setNumber("11111111");
        cardEntity2.setNumber("11111112");
//        cardEntity3.setNumber("11111111");
        cardService.save(cardEntity1);
        cardService.save(cardEntity2);
//        cardService.save(cardEntity3);
        System.out.println("cards created");
        System.out.println();

//        System.out.printf(cardService.findCardByNumber("11111111").toString());
        return "main";
    }
}
