package com.atm.data.repository;

import com.atm.data.entity.CardEntity;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.util.EncryptionUtil;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;

@Log
@Repository
public class CardEntityRepositoryImpl implements CardEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CardEntity card) {
        entityManager.persist(card);
        log.log(Level.INFO, "Card was saved", card);
    }

    @Override
    public void update(CardEntity card) {
        entityManager.merge(card);
        log.log(Level.INFO, "Card was updated", card);
    }

    @Override
    public CardEntity findById(long id) {
        CardEntity card = entityManager.find(CardEntity.class, id);
        log.log(Level.INFO, "Card was found by id", card);
        return card;
    }

    @Override
    public CardEntity findCardByNumber(String number) {
        CardEntity card = (CardEntity) entityManager.createNamedQuery(CardEntity.FIND_CARD_BY_NUMBER)
                .setParameter("number", number)
                .getResultList()
                .get(0);
        log.log(Level.INFO, "Card was found by number", card);
        return card;
    }

    @Override
    public List getCardStatusByNumber(String number) {
        List cardStatusList = entityManager.createNamedQuery(CardEntity.GET_CARD_STATUS_BY_NUMBER)
                .setParameter("number", number)
                .setMaxResults(1)
                .getResultList();
        log.log(Level.INFO, "Card_status list was found by number");
        return cardStatusList;
    }

    @Override
    public List findCardByNumberAndPassword(ClientInfoDto client) {
        List cardList = entityManager.createNamedQuery(CardEntity.FIND_CARD_BY_NUMBER_AND_PASSWORD)
                .setParameter("number", EncryptionUtil.encode(client.getNumber()))
                .setParameter("password", EncryptionUtil.encode(client.getPassword()))
                .setMaxResults(1)
                .getResultList();
        log.log(Level.INFO, "Card list was found by number and password");
        return cardList;
    }
}
