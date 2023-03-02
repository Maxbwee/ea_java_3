package com.example.ea_java_3.domain.character.service;

import com.example.ea_java_3.domain.character.dto.CharacterPostDTO;
import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.dto.CharacterDTO;
import com.example.ea_java_3.domain.shared.CrudService;

import java.util.List;

/**
 *
 */
public interface CharacterService extends CrudService<Character, CharacterPostDTO> {}
