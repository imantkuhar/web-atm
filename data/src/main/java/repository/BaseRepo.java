package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Imant on 27.05.17.
 */
public interface BaseRepo<ENTITY, ID extends Serializable>  extends JpaRepository<ENTITY, ID> {
}
