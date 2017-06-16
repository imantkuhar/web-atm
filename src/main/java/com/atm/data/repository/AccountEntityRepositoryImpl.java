package com.atm.data.repository;

import javax.persistence.EntityManager;

import com.atm.data.entity.AccountEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

@Repository
public class AccountEntityRepositoryImpl implements AccountEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AccountEntity account) {
        entityManager.persist(account);
    }

    @Override
    public void update(AccountEntity account) {
        entityManager.merge(account);
    }

    @Override
    public AccountEntity findById(long id) {
        return entityManager.find(AccountEntity.class, id);
    }
}
