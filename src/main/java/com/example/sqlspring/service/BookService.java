package com.example.sqlspring.service;

import com.example.sqlspring.entity.Book;

public interface BookService extends CrudService<Book, Long>{

    void test(String genreName);


}
