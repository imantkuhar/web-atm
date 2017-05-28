package entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Imant on 27.05.17.
 */
@Data
@Entity
@Table(name = "CARDS")
public class CardEntity extends BaseEntity {

    @Column(name = "number")
    private String number;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private int balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;
}