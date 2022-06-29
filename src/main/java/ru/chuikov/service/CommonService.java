package ru.chuikov.service;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

public interface CommonService<T> {
    T add(T t) throws Exception;
    List<T> addAll(Collection<T> ts) throws Exception;
    T getById(Long id) throws Exception;
    T update(T t) throws FileNotFoundException;
    void deleteById(Long id);
    void deleteById(T t);
    Collection<T> getAll();
}
