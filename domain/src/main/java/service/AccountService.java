package service;

import entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

/**
 * Created by Imant on 28.05.17.
 */
@Service
public class AccountService implements BaseService<AccountEntity> {

    @Autowired
    private AccountRepository accountRepository;

    public void save(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }

    public void delete(AccountEntity accountEntity) {
        accountRepository.delete(accountEntity);
    }

    public AccountEntity find(int id) {
        return accountRepository.findOne(id);
    }

    public void update(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }
}
