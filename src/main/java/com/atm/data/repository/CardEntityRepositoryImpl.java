package com.atm.data.repository;

import com.atm.data.entity.CardEntity;
import com.atm.domain.dto.ClientInfoDto;
import com.atm.domain.util.EncryptionUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
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
    public CardEntity findCardByNumber(String number) {
        CardEntity cardEntity = (CardEntity) entityManager.createNamedQuery(CardEntity.FIND_CARD_BY_NUMBER)
                .setParameter("number", number)
                .getResultList()
                .get(0);
        return cardEntity;
    }

    @Override
    public List getCardStatusByNumber(String number) {
        return entityManager.createNamedQuery(CardEntity.GET_CARD_STATUS_BY_NUMBER)
                .setParameter("number", number)
                .getResultList();
    }

    @Override
    public List findCardByNumberAndPassword(ClientInfoDto client) {
        return entityManager.createNamedQuery(CardEntity.FIND_CARD_BY_NUMBER_AND_PASSWORD)
                .setParameter("number", EncryptionUtil.encode(client.getNumber()))
                .setParameter("password", EncryptionUtil.encode(client.getPassword()))
                .getResultList();
    }

}
