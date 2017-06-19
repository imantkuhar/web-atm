package com.atm.data.repository;

import com.atm.data.entity.AccountEntity;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;

@Log
@Repository
public class AccountEntityRepositoryImpl implements AccountEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(AccountEntity account) {
        entityManager.persist(account);
        log.log(Level.INFO, "Account was saved", account);
    }

    @Override
    public void update(AccountEntity account) {
        entityManager.merge(account);
        log.log(Level.INFO, "Account was updated", account);
    }

    @Override
    public AccountEntity findById(long id) {
        AccountEntity account = entityManager.find(AccountEntity.class, id);
        log.log(Level.INFO, "Account was found by id", account);
        return account;
    }
}
