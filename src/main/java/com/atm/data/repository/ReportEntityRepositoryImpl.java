package com.atm.data.repository;

import com.atm.data.entity.ReportEntity;
import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;

@Log
@Repository
public class ReportEntityRepositoryImpl implements ReportEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ReportEntity report) {
        entityManager.persist(report);
        log.log(Level.INFO, "Report was saved", report);
    }

    @Override
    public ReportEntity findById(long id) {
        ReportEntity report = entityManager.find(ReportEntity.class, id);
        log.log(Level.INFO, "Report was found by id", report);
        return report;
    }
}
