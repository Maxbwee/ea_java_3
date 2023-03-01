package com.example.ea_java_3.domain.character.service;

import com.example.ea_java_3.domain.character.dto.CharacterMapper;
import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.dto.CharacterDTO;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the characterService
 * Uses the character repository to interact with the data
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepo;
    private final MovieRepository movieRepository;
    private final CharacterMapper mapper;

    public CharacterServiceImpl(CharacterRepository characterRepo, MovieRepository movieRepository, CharacterMapper mapper) {
        this.characterRepo = characterRepo;
        this.mapper = mapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public Character create(CharacterDTO dto) {
        return characterRepo.save(mapper.toCharacter(dto));
    }

    @Override
    public Character getById(int id) {
        Character ch = characterRepo.findCharacterById(id);
        Set<Movie> movies = movieRepository.findAllByCharacterId(id).stream().collect(Collectors.toSet());
        ch.setMovies(movies);
        System.out.println("CHARACTER MOVIES: " + ch.getMovies());
        return ch;
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
