package com.example.sqlspring.repository;

import com.example.sqlspring.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("SELECT a FROM Author a WHERE a.books IS EMPTY")
    List<Author> findAuthorsWithoutBooks();


}
