package ru.chuikov.service;

import java.util.Collection;
import java.util.Optional;

public interface CommonService<T> {
    void add(T t);
    Optional<T> getById(Long id);
    void updateById(T t);
    void deleteById(Long id);
    void deleteById(T t);
    Collection<T> getAll();
}
