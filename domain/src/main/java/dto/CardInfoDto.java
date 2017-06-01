package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Imant on 28.05.17.
 */
@Data
@AllArgsConstructor
public class CardInfoDto {

    private String cardNumber;
    private String fullName;
    private String address;
    private String date;
    private int balance;
    private int removedAmount;
}
