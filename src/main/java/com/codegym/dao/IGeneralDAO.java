package com.codegym.dao;

import java.util.List;

public interface IGeneralDAO<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(int id, T t);
    boolean delete(int id);
}
