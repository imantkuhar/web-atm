package com.atm.domain.service;

import com.atm.data.entity.ReportEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Imant on 05.06.17.
 */
public interface ReportEntityService {

    void save(ReportEntity report);

    void update(ReportEntity report);

    ReportEntity findById(long id);
}
