package com.atm.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Imant on 29.05.17.
 */
@Data
@AllArgsConstructor
public class ReportInfoDto {

    private String cardNumber;
    private String date;
    private int removedAmount;
    private int balance;
}
