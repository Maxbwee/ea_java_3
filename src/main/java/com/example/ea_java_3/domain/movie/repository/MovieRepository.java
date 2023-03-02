package com.example.ea_java_3.domain.movie.repository;

import com.example.ea_java_3.domain.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT movie.id, movie.title, movie.genre, movie.release_year,movie.director,movie.picture,movie.trailer, movie.franchise_id FROM movie " +
            "LEFT JOIN franchise on franchise.id = movie.franchise_id " +
            "WHERE franchise.id = ?", nativeQuery = true)
    List<Movie> findAllByFranchiseId(int id);

    @Query(value = "SELECT movie.id, movie.title, movie.genre, movie.release_year,movie.director,movie.picture,movie.trailer, movie.franchise_id FROM movie " +
            "LEFT JOIN character_movie ON character_movie.movie_id=movie.id " +
            "WHERE character_id=?", nativeQuery = true)
    List<Movie> findAllByCharacterId(int id);

}
