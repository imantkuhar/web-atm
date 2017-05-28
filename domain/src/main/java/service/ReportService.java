package service;

import entity.ReportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CardRepository;
import repository.ReportRepository;

/**
 * Created by Imant on 28.05.17.
 */
@Service
public class ReportService implements BaseService<ReportEntity> {

    @Autowired
    private ReportRepository reportRepository;

    public void save(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
    }

    public void delete(ReportEntity reportEntity) {
        reportRepository.delete(reportEntity);
    }

    public ReportEntity find(int id) {
        return reportRepository.findOne(id);
    }

    public void update(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
    }
}
