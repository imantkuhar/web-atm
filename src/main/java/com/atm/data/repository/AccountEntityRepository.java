package com.atm.data.repository;

import com.atm.data.entity.AccountEntity;

public interface AccountEntityRepository {

    void save(AccountEntity account);

    void update(AccountEntity account);

    AccountEntity findById(long id);
}
