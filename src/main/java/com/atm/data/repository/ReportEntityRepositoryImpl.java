package com.atm.data.repository;

import com.atm.data.entity.ReportEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReportEntityRepositoryImpl implements ReportEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ReportEntity report) {
        entityManager.persist(report);
    }

    @Override
    public void update(ReportEntity report) {
        entityManager.merge(report);
    }

    @Override
    public ReportEntity findById(long id) {
        return entityManager.find(ReportEntity.class, id);
    }
}
