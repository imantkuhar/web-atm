package com.atm.domain.mapper;

import com.atm.data.entity.CardEntity;
import com.atm.domain.util.EncryptionUtil;
import com.atm.domain.dto.ClientInfoDto;

/**
 * Created by Imant on 05.06.17.
 */
public class ClientInfoMapper {

    public static void convertCardEntityToClientDto(CardEntity card, ClientInfoDto client) {
        client.setNumber(EncryptionUtil.decode(card.getNumber().getBytes()));
        client.setPassword(EncryptionUtil.decode(card.getPassword().getBytes()));
        client.setBalance(card.getBalance());
        client.setFullName(card.getAccountEntity().getFullName());
        client.setAddress(card.getAccountEntity().getAddress());
        client.setFullAccess(true);
    }
}



