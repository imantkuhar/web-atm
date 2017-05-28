package entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Imant on 27.05.17.
 */
@Data
@Entity
@Table(name = "REPORTS")
public class ReportEntity extends BaseEntity {

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "date")
    private String date;

    @Column(name = "amount_withdraw")
    private int amountWithdraw;

    @Column(name = "balance")
    private int balance;

    @OneToOne
    @JoinColumn(name = "card_number")
    private CardEntity cardEntity;
}
