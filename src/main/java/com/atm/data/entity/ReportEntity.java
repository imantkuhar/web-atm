package com.atm.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Imant on 27.05.17.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "REPORTS")
public class ReportEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "card_number")

    private CardEntity cardEntity;

    @Column(name = "date")
    private String date;

    @Column(name = "withdraw_amount")
    private Integer withdrawAmount;

    @Column(name = "balance")
    private Integer balance;

    public ReportEntity(CardEntity cardEntity, String date, Integer withdrawAmount, Integer balance) {
        this.cardEntity = cardEntity;
        this.date = date;
        this.withdrawAmount = withdrawAmount;
        this.balance = balance;
    }
}
