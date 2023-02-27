package com.example.ea_java_3.domain.character.repository;

import com.example.ea_java_3.domain.character.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    Set<Character> findAllByName(String name);
    Optional<Character> findCharacterByMovies(String title);

    Optional<Character> findCharacterById(int id);
    Optional<Character> findCharacterByName(String name);
    Optional<Character> deleteCharacterById(int id);
}
