package com.atm.data.repository;

import com.atm.data.entity.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEntityRepository {

    void save(AccountEntity account);

    void update(AccountEntity account);

    AccountEntity findById(long id);
}
