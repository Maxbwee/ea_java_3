package com.example.ea_java_3.domain.character.service;

import com.example.ea_java_3.domain.character.dto.CharacterMapper;
import com.example.ea_java_3.domain.character.dto.CharacterPostDTO;
import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;

import com.example.ea_java_3.exceptions.exc.CharacterInMoviesException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Character create(CharacterPostDTO dto) {
        return characterRepo.save(mapper.toCharacter(dto));
    }

    @Override
    public Character getById(int id) {
        Character ch = characterRepo.findCharacterById(id);
        Set<Movie> movies = new HashSet<>(movieRepository.findAllByCharacterId(id));
        ch.setMovies(movies);
        System.out.println("CHARACTER MOVIES: " + ch.getMovies());
        return ch;
    }

    @Override
    public List<Character> getAll() {
        List<Character> chars = characterRepo.findAll();
        chars.forEach(it -> {
            Set<Movie> movies = new HashSet<>(movieRepository.findAllByCharacterId(it.getId()));
            it.setMovies(movies);
        });
        return chars;
    }

    @Override
    public void deleteById(int id) {
       List<Movie> charMovies =  movieRepository.findAllByCharacterId(id);
       if (!charMovies.isEmpty()){
           throw new CharacterInMoviesException(charMovies.size());
       }
       characterRepo.deleteById(id);
    }

    @Override
    public Character update(int id, CharacterPostDTO dto) {
        Character ch = mapper.toCharacter(dto);
        ch.setId(id);
        ch.setMovies(Set.of());
        return characterRepo.save(ch);
    }
}
