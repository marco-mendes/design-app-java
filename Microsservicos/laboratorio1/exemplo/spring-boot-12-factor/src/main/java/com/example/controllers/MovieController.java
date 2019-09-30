package com.example.controllers;

import com.example.entities.Movie;
import com.example.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    @GetMapping("/movies")
    public List<Movie> retrieveAllStudents() {
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie retrieveStudent(@PathVariable Long id) {
        return movieRepository.findById(id).get();
    }

    @PostMapping("/movies")
    public Long createStudent(@RequestBody Movie movie) {
        return movieRepository.save(movie).getId();
    }
}