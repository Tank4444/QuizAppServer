package ru.chuikov.service;

import java.util.Collection;

public interface CommonService<T> {
    void add(T t);
    void addAll(Collection<T> ts);
    T getById(Long id);
    void update(T t);
    void deleteById(Long id);
    void deleteById(T t);
    Collection<T> getAll();
}
