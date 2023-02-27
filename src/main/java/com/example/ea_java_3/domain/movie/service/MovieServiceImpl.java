package com.example.ea_java_3.domain.movie.service;

import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.exceptions.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;

    public MovieServiceImpl(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public Movie create(Integer dto) {
        return null;
    }

    @Override
    public Movie getById(int id) {
        return movieRepo.findMovieById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public Movie deleteById(int id) {
        return null;
    }

    @Override
    public Movie update(Integer dto) {
        return null;
    }
}
