package co.edu.uptc.persistence;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    void save(List<T> items);
    T findById(int id);
    void update(T entity);
    void delete(int id);
    List<T> findAll();
}
