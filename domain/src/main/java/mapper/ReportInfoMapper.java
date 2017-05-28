package mapper;

import dto.ReportInfoDto;
import entity.ReportEntity;
import util.DateService;

/**
 * Created by Imant on 29.05.17.
 */
public class ReportInfoMapper {

    public static ReportInfoDto convertToReportInfoDto(ReportEntity report, int amountWithdraw) {
        String cardNumber = report.getCardNumber();
        String date = DateService.getCurrentDate();
        int balance = report.getBalance();
        ReportInfoDto reportInfoDto = new ReportInfoDto(cardNumber, date, amountWithdraw, balance);
        return reportInfoDto;
    }
}
