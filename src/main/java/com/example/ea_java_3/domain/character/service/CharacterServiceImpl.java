package com.example.ea_java_3.domain.character.service;

import com.example.ea_java_3.domain.character.dto.CharacterMapper;
import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.dto.CharacterDTO;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.exceptions.CharacterNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the characterService
 * Uses the character repository to interact with the data
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepo;
    private final CharacterMapper mapper;

    public CharacterServiceImpl(CharacterRepository characterRepo, CharacterMapper mapper) {
        this.characterRepo = characterRepo;
        this.mapper = mapper;
    }

    @Override
    public Character create(CharacterDTO dto) {
        return characterRepo.save(mapper.toCharacter(dto));
    }

    @Override
    public Character getById(int id) {
        return characterRepo.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public List<Character> getAll() {
        return characterRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
       characterRepo.deleteById(id);
    }

    @Override
    public Character update(CharacterDTO dto) {
        return characterRepo.save(mapper.toCharacter(dto));
    }
}
