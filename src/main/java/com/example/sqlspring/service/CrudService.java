package com.example.sqlspring.service;

import com.example.sqlspring.entity.Book;

import java.util.List;

public interface CrudService<T, ID> {
    T save(T entity);
    T findById(ID id);

    List<T> findAll();

    T update(ID id, T entity);

    void deleteById(ID id);
}
