package com.atm.domain.service;

import com.atm.data.entity.ReportEntity;
import com.atm.data.repository.ReportEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Imant on 05.06.17.
 */
@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportEntityRepository reportRepository;

    @Override
    public void save(ReportEntity report) {
        reportRepository.save(report);
    }

    @Override
    public ReportEntity findById(long id) {
        return reportRepository.findById(id);
    }
}
