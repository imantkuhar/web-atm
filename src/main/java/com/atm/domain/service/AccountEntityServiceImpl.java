package com.atm.domain.service;

import com.atm.data.entity.AccountEntity;
import com.atm.data.repository.AccountEntityRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountEntityServiceImpl implements BaseEntityService<AccountEntity> {

    @Autowired
    private AccountEntityRepositoryImpl accountRepository;

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
        return accountRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        accountRepository.delete(id);
    }
}
