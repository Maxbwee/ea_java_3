package com.example.ea_java_3.domain.character.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.model.CharacterDTO;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.exceptions.CharacterNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the characterService
 * Uses the character repository to interact with the data
 * Logger is used to log errors
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepo;
    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepo) {
        this.characterRepo = characterRepo;
    }

    @Override
    public Collection<Character> findAllByName(String name) {
        return characterRepo.findAllByName(name);
    }

    @Override
    public Character create(CharacterDTO dto) {
        // Transform object??
        return null;
    }

    @Override
    public Character getById(int id) {
        return characterRepo.findCharacterById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public List<Character> getAll() {
        return null;
    }

    @Override
    public Character deleteById(int id) {
        return null;
    }

    @Override
    public Character update(CharacterDTO dto) {
        return null;
    }
}
