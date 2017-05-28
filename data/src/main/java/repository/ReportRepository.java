package repository;

import entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Imant on 28.05.17.
 */
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {
}
