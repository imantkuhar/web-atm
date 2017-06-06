package com.atm.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.relation.InvalidRelationTypeException;

/**
 * Created by Imant on 05.06.17.
 */
@Data
public class ClientInfoDto {
    private Long id;
    private String password;
    private String fullName;
    private String address;
    private Integer balance;
    private Integer passwordCounter;
    private String date;

    public ClientInfoDto(Long id, String password, String fullName, String address, Integer balance, Integer passwordCounter, String date) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.balance = balance;
        this.passwordCounter = passwordCounter;
        this.date = date;
    }
}
