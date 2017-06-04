package com.atm.domain.service;

import com.atm.data.entity.CardEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Imant on 28.05.17.
 */
@Service
public interface CardEntityService {

    void save(CardEntity card);

    void update(CardEntity card);

    CardEntity findById(long id);

    CardEntity findCardByNumber(String string);
}