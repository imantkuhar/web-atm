package repository;

import entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Imant on 27.05.17.
 */
public interface AccountRepository extends JpaRepository<AccountEntity, Integer> {
}
