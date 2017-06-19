package com.atm.domain.service;

import com.atm.data.entity.CardEntity;
import com.atm.data.repository.CardEntityRepository;
import com.atm.domain.dto.ClientInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Imant on 04.06.17.
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardEntityRepository cardRepository;

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
        return cardRepository.findById(id);
    }

    @Override
    public CardEntity findCardByNumber(String string) {
        return cardRepository.findCardByNumber(string);
    }

    @Override
    public List getCardStatusByNumber(String string) {
        return cardRepository.getCardStatusByNumber(string);
    }

    @Override
    public List findCardByNumberAndPassword(ClientInfoDto client) {
        return cardRepository.findCardByNumberAndPassword(client);
    }
}
