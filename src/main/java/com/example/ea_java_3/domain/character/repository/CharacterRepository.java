package com.example.ea_java_3.domain.character.repository;

import com.example.ea_java_3.domain.character.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<Character> findAllByName(String name);
    Optional<Character> findCharacterById(int id);
    Optional<Character> findCharacterByName(String name);
    Optional<Character> deleteCharacterById(int id);

//    @Query("select s from Character s where s.id like %?1%");
    @Query("SELECT id FROM Character")
    List<Character> findAllByFranchiseId(int id);
}
