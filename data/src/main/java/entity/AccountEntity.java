package entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Imant on 27.05.17.
 */
@Data
@Entity
@Table(name = "ACCOUNTS")
public class AccountEntity extends BaseEntity {

    @Column(name = "age")
    private int age;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "job")
    private String job;
}
