package com.atm.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Imant on 12.06.17.
 */
@Data
@NoArgsConstructor
public class ClientInfoDto {
    String number;
    String password;
    private String fullName;
    private String address;
    private String date;
    private Integer balance;
    private Integer removedAmount;

    public ClientInfoDto(String number, String password, String fullName, String address, Integer balance) {
        this.number = number;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.balance = balance;
    }
}
