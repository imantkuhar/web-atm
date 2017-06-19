package com.atm.domain.service;

import com.atm.data.entity.AccountEntity;
import com.atm.data.repository.AccountEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountEntityRepository accountRepository;

    @Override
    public void save(AccountEntity account) {
        accountRepository.save(account);
    }

    @Override
    public void update(AccountEntity account) {
        accountRepository.update(account);
    }

    @Override
    public AccountEntity findById(long id) {
        return accountRepository.findById(id);
    }
}
