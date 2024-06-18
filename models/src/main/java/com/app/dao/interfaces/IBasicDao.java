package com.app.dao.interfaces;

import java.util.List;

public interface IBasicDao<T> {

    void save(T item);

    T getById(Long id);

    List<T> getAll();

    /* void delete(Long id); */
}
