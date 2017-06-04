package com.atm.domain.service;

/**
 * Created by Imant on 28.05.17.
 */
public interface BaseEntityService<T> {

    void save(T t);

    void update(T t);

    T findById(long id);

    void delete(long id);
}