package com.atm.data.entity;

import javax.persistence.*;

/**
 * Created by Imant on 27.05.17.
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
