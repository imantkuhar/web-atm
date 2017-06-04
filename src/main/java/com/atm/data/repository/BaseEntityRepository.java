package com.atm.data.repository;


public interface BaseEntityRepository<T> {
    void save(T t);

    void update(T t);

    T getById(long id);

    void delete(long id);
}
