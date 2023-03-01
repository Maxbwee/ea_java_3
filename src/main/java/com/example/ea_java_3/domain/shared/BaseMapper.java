package com.example.ea_java_3.domain.shared;

import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Base mapper providing common mapper methods for the domain models.
 */
public abstract class BaseMapper {
    @Autowired
    private MovieRepository movieRepository;

    @Named("movieIdsToMovies")
    public Set<Movie> movieIdsToMovies(Set<Integer> ids) {
        return ids.stream().map(it -> movieRepository.findById(it).get()).collect(Collectors.toSet());
    }

    @Named("moviesToIds")
    public Set<Integer> moviesToIds(Set<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toSet());
    }
}
