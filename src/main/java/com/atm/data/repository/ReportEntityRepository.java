package com.atm.data.repository;

import com.atm.data.entity.ReportEntity;

/**
 * Created by Imant on 05.06.17.
 */
public interface ReportEntityRepository {

    void save(ReportEntity report);

    void update(ReportEntity report);

    ReportEntity findById(long id);
}
