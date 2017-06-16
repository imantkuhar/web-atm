package com.atm.data.repository;

import com.atm.data.entity.CardEntity;
import com.atm.domain.dto.ClientInfoDto;

import java.util.List;

public interface CardEntityRepository {

    void save(CardEntity card);

    void update(CardEntity card);

    CardEntity findById(long id);

    CardEntity findCardByNumber(String string);

    List getCardStatusByNumber(String string);

    List findCardByNumberAndPassword(ClientInfoDto client);
}
