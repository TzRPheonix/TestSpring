package com.example.sqlspring.controller;

import com.example.sqlspring.entity.Publisher;
import com.example.sqlspring.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getALlPublisher(){
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getGenreById(@PathVariable Long id){
        Publisher publisher = publisherService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(publisher);
    }
}
