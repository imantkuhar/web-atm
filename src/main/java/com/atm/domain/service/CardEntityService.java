package com.atm.domain.service;

import com.atm.data.entity.CardEntity;
import com.atm.domain.dto.ClientInfoDto;

import java.util.List;

/**
 * Created by Imant on 28.05.17.
 */
public interface CardEntityService {

    void save(CardEntity card);

    void update(CardEntity card);

    CardEntity findById(long id);

    CardEntity findCardByNumber(String string);

    List getCardStatusByNumber(String string);

    List findCardByNumberAndPassword(ClientInfoDto client);
}