package com.atm.domain.service;

import com.atm.data.entity.AccountEntity;

/**
 * Created by Imant on 28.05.17.
 */
public interface AccountService {

    void save(AccountEntity account);

    void update(AccountEntity account);

    AccountEntity findById(long id);
}