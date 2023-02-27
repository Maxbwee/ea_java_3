package com.example.ea_java_3.domain.character.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.model.CharacterDTO;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.shared.CrudService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface CharacterService extends CrudService<Character, CharacterDTO> {

    Collection<Character> findAllByName(String name);

}
