package mapper;

import dto.CardInfoDto;
import entity.AccountEntity;
import entity.CardEntity;
import entity.Status;
import util.DateService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Imant on 28.05.17.
 */
public class CardInfoMapper {

    public static CardInfoDto convertToCardInfoDto(AccountEntity account, CardEntity card) {
        String fullName = account.getFullName();
        String address = account.getAddress();
        String date = DateService.getCurrentDate();
        int balance = card.getBalance();
        CardInfoDto cardInfoDto = new CardInfoDto(fullName, address, date, balance);
        return cardInfoDto;
    }
}
