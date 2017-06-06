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
    private Integer amountWithdraw;

    @Column(name = "balance")
    private Integer balance;

    public ReportEntity(CardEntity cardEntity, String date, Integer amountWithdraw, Integer balance) {
        this.cardEntity = cardEntity;
        this.date = date;
        this.amountWithdraw = amountWithdraw;
        this.balance = balance;
    }
}
