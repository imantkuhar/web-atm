package repository;

import entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Imant on 28.05.17.
 */
public interface CardRepository extends JpaRepository<CardEntity, Integer> {
}
