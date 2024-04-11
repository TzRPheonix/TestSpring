package com.example.sqlspring.service.impl;

import com.example.sqlspring.entity.Author;
import com.example.sqlspring.entity.Book;
import com.example.sqlspring.repository.AuthorRepository;
import com.example.sqlspring.service.AuthorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public Author save(Author entity) {
        return authorRepository.save(entity);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author not Found"));
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    @Override
    public Author update(Long id, Author entity) {
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author not found"));
        author.setName(entity.getName());
        author.setBooks(entity.getBooks());
        return authorRepository.save(author);

    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.getBooks().forEach(book -> {
            book.setAuthor(null);
        });
        author.getBooks().clear();
        authorRepository.save(author);
        authorRepository.delete(author);
    }

    @Override
    public void test() {
        System.out.println(authorRepository.findAuthorsWithoutBooks());
    }
}
