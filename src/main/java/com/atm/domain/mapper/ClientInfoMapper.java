package com.atm.domain.mapper;

import com.atm.data.entity.AccountEntity;
import com.atm.data.entity.CardEntity;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.util.DateService;

import java.util.Date;

/**
 * Created by Imant on 05.06.17.
 */
public class ClientInfoMapper {

    public static ClientInfoDto convertToClientDto(CardEntity card){
        Long id = card.getId();
        String password = card.getPassword();
        Integer balance = card.getBalance();
        AccountEntity account = card.getAccountEntity();
        String fullName = account.getFullName();
        String address = account.getAddress();
        Integer passwordCounter = 0;
        String date = DateService.getCurrentDate();
        ClientInfoDto clientDto = new ClientInfoDto(id, password, fullName, address, balance, passwordCounter, date);
        return clientDto;
    }
}