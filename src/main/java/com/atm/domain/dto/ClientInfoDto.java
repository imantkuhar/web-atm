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
    private boolean confirmedNumber = false;
    private boolean fullAccess = false;
    private int passwordCounter = 1;
    private String address;
    private Integer balance;
    private String date;
    private Integer withdrawAmount;

    public ClientInfoDto(String number, String password) {
        this.number = number;
        this.password = password;
    }
}
