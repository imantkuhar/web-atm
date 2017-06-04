package com.atm.webapi;

import com.atm.data.entity.AccountEntity;
import com.atm.domain.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class CardController {

    @Autowired
    private BaseEntityService accountService;

    @RequestMapping("/main")
    public String game() {
        AccountEntity account1 = new AccountEntity(111, "dimon", "harkiv", "yes");
        accountService.save(account1);
        System.out.println("account1 created");
        account1.setAge(33);
        accountService.update(account1);
        System.out.println("account1 updated");
        System.out.println(account1.getId());
        System.out.println(accountService.findById(account1.getId()).toString());
        return "main";
    }
}
