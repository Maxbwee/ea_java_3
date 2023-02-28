package com.example.ea_java_3.domain.character.repository;

import com.example.ea_java_3.domain.character.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Query(
            value="SELECT character.id, character.name, character.alias, character.gender, character.picture FROM character " +
            "LEFT JOIN character_movie ON character_movie.character_id=character.id " +
            "LEFT JOIN movie ON character_movie.movie_id=movie.id " +
            "WHERE movie.franchise_id = ?", nativeQuery = true)
    List<Character> findAllByFranchiseId(int id);

    @Query(value="SELECT character.id, character.name, character.alias, character.gender, character.picture FROM character " +
            "LEFT JOIN character_movie ON character_movie.character_id=character.id " +
            "WHERE character_movie.movie_id = 1", nativeQuery = true)
    List<Character> findAllByMovieId(int id);
}
