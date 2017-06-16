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
@Table(name = "CARDS")
@NamedQueries({
        @NamedQuery(name = CardEntity.FIND_CARD_BY_NUMBER, query = "SELECT c FROM CardEntity c WHERE c.number = :number"),
        @NamedQuery(name = CardEntity.GET_CARD_STATUS_BY_NUMBER, query = "SELECT c.status FROM CardEntity c WHERE c.number = :number"),
        @NamedQuery(name=CardEntity.FIND_CARD_BY_NUMBER_AND_PASSWORD, query="SELECT c FROM CardEntity c WHERE " +
                "c.number = :number AND c.password = :password"),
})
public class CardEntity extends BaseEntity {

    public static final String FIND_CARD_BY_NUMBER = "findCardByNumber";
    public static final String GET_CARD_STATUS_BY_NUMBER = "getCardStatusByNumber";
    public static final String FIND_CARD_BY_NUMBER_AND_PASSWORD = "findCardByNumberAndPassword";

    @Column(name = "number", unique=true)
    private String number;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private Integer balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

    public CardEntity(String number, String password, Integer balance, Status status, AccountEntity accountEntity) {
        this.number = number;
        this.password = password;
        this.balance = balance;
        this.status = status;
        this.accountEntity = accountEntity;
    }
}
