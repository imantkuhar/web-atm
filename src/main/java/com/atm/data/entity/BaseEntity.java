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
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
