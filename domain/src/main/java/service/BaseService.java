package service;

/**
 * Created by Imant on 28.05.17.
 */
public interface BaseService<T> {

    void save(T t);

    void delete(T t);

    T find(int id);

    void update(T t);
}
