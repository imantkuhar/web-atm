package com.atm.domain.service;

import com.atm.data.entity.ReportEntity;

/**
 * Created by Imant on 05.06.17.
 */
public interface ReportService {

    void save(ReportEntity report);

    ReportEntity findById(long id);
}
