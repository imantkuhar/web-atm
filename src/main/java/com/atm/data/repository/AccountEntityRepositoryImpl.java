package com.atm.data.repository;

import javax.persistence.EntityManager;
import com.atm.data.entity.AccountEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

@Repository
public class AccountEntityRepositoryImpl implements BaseEntityRepository<AccountEntity> {

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
    public AccountEntity getById(long id) {
        return entityManager.find(AccountEntity.class, id);
    }

    @Override
    public void delete(long id) {
        AccountEntity account = getById(id);
        if (account != null) {
            entityManager.remove(account);
        }
    }
}
