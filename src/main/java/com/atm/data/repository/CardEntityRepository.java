package com.atm.data.repository;

import com.atm.data.entity.CardEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CardEntityRepository {

    void save(CardEntity card);

    void update(CardEntity card);

    CardEntity findById(long id);

    CardEntity findCardByNumber(String string);
}
