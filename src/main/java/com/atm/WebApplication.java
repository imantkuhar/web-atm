package com.atm;

import com.atm.data.entity.AccountEntity;
import com.atm.data.entity.CardEntity;
import com.atm.data.entity.Status;
import com.atm.domain.service.AccountService;
import com.atm.domain.service.CardService;
import com.atm.domain.util.EncryptionUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    @Autowired
    AccountService accountService;
    @Autowired
    CardService cardService;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
//        testData();
    }

    private void testData() {
        AccountEntity account1 = new AccountEntity(20, "Ivan", "Kiev", "Office");
        AccountEntity account2 = new AccountEntity(25, "Dima", "Lviv", "Bank");
        AccountEntity account3 = new AccountEntity(30, "Andrey", "Odessa", "Shop");
        accountService.save(account1);
        accountService.save(account2);
        accountService.save(account3);

        String number1 = EncryptionUtil.encode("1111");
        String password1 = EncryptionUtil.encode("1111");
        CardEntity cardEntity1 = new CardEntity(number1, password1, 10000, Status.FREE, account1);

        String number2 = EncryptionUtil.encode("2222");
        String password2 = EncryptionUtil.encode("2222");
        CardEntity cardEntity2 = new CardEntity(number2, password2, 20000, Status.FREE, account2);

        String number3 = EncryptionUtil.encode("3333");
        String password3 = EncryptionUtil.encode("3333");
        CardEntity cardEntity3 = new CardEntity(number3, password3, 30000, Status.FREE, account3);

        cardService.save(cardEntity1);
        cardService.save(cardEntity2);
        cardService.save(cardEntity3);
    }
}
