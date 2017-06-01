package mapper;

import dto.ReportInfoDto;
import entity.ReportEntity;
import util.DateService;

/**
 * Created by Imant on 29.05.17.
 */
public class ReportInfoMapper {

    public static ReportInfoDto convertToReportInfoDto(ReportEntity report) {
        String cardNumber = report.getCardNumber();
        String date = DateService.getCurrentDate();
        int balance = report.getBalance();
        int amountToRemove = report.getAmountWithdraw();
        ReportInfoDto reportInfo = new ReportInfoDto(cardNumber, date, amountToRemove, balance);
        return reportInfo;
    }
}
