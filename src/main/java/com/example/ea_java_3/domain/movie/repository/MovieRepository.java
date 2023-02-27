package com.example.ea_java_3.domain.movie.repository;

import com.example.ea_java_3.domain.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findMovieById(int id);
    List<Movie> findAllByFranchiseId(int id);
}
