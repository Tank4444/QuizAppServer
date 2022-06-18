package ru.chuikov.service;

import java.util.Collection;

public interface CommonService<T> {
    void save(T t);
    T getById(Long id);
    T updateById(T t);
    void deleteById(Long id);
    void deleteById(T t);
    Collection<T> getAll();
}
