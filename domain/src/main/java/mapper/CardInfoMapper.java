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

    public static CardInfoDto convertToCardInfoDto(CardEntity card) {
        AccountEntity account = card.getAccountEntity();
        String cardNumber = card.getNumber();
        String fullName = account.getFullName();
        String address = account.getAddress();
        String date = DateService.getCurrentDate();
        int balance = card.getBalance();
        int removeAmount = 0;
        CardInfoDto cardInfo = new CardInfoDto(cardNumber, fullName, address, date, balance, removeAmount);
        return cardInfo;
    }

//    public static CardEntity convertToCardEntity(CardInfoDto card){
//    }
}
