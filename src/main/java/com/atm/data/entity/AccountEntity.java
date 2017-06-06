package com.atm.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Imant on 27.05.17.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "CLIENTS")
public class AccountEntity extends BaseEntity {

    @Column(name = "age")
    private Integer age;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "job")
    private String job;

    public AccountEntity(Integer age, String fullName, String address, String job) {
        this.age = age;
        this.fullName = fullName;
        this.address = address;
        this.job = job;
    }
}