package com.atm.data.repository;

import com.atm.data.entity.ReportEntity;

public interface ReportEntityRepository {

    void save(ReportEntity report);

    ReportEntity findById(long id);
}
