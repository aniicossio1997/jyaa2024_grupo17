package com.app.dao.interfaces;

import java.util.List;

public interface IBasicDao<T> {

    void save(T item);
    T getById(Long id);
    List<T> getAll();
    List<T> getAll(boolean isActive);
    T getById(Long id, boolean isActive);
}
