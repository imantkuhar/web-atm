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
@Table(name = "REPORTS")
public class ReportEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "card_number")
    private CardEntity cardEntity;

    @Column(name = "date")
    private String date;

    @Column(name = "amount_withdraw")
    private int amountWithdraw;

    @Column(name = "balance")
    private int balance;

    public ReportEntity(CardEntity cardEntity, String date, int amountWithdraw, int balance) {
        this.cardEntity = cardEntity;
        this.date = date;
        this.amountWithdraw = amountWithdraw;
        this.balance = balance;
    }
}
