package com.example.sqlspring.service.impl;

import com.example.sqlspring.entity.Book;
import com.example.sqlspring.entity.Genre;
import com.example.sqlspring.repository.GenreRepository;
import com.example.sqlspring.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found with id " + id));
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre update(Long id, Genre genreDetails) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with id " + id));
        genre.setName(genreDetails.getName());
        genre.setBooks(genreDetails.getBooks());
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with id " + id));
        genreRepository.delete(genre);
    }
}
