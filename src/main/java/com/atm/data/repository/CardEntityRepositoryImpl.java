package com.atm.data.repository;

import com.atm.data.entity.CardEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Imant on 04.06.17.
 */
@Repository(value = "cardRepository")
public class CardEntityRepositoryImpl implements CardEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(CardEntity card) {
        entityManager.persist(card);
    }

    @Override
    public void update(CardEntity card) {
        entityManager.merge(card);
    }

    @Override
    public CardEntity findById(long id) {
        return entityManager.find(CardEntity.class, id);
    }

    @Override
    public CardEntity findCardByNumber(String cardNumber) {
        CardEntity cardEntity = (CardEntity) entityManager.createNamedQuery(CardEntity.FIND_CARD_BY_NUMBER)
                .setParameter("number", cardNumber)
                .getResultList()
                .get(0);
        return cardEntity;
    }
}
