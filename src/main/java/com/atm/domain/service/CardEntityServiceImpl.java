package com.atm.domain.service;

import com.atm.data.entity.CardEntity;
import com.atm.data.repository.CardEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Imant on 04.06.17.
 */
@Service(value = "cardService")
@Transactional
public class CardEntityServiceImpl implements CardEntityService {

    @Autowired
    @Qualifier("cardRepository")
    CardEntityRepository cardRepository;

    @Override
    public void save(CardEntity card) {
        cardRepository.save(card);
    }

    @Override
    public void update(CardEntity card) {
        cardRepository.update(card);
    }

    @Override
    public CardEntity findById(long id) {
        return (CardEntity) cardRepository.findById(id);
    }

    @Override
    public CardEntity findCardByNumber(String string) {
        return cardRepository.findCardByNumber(string);
    }
}
