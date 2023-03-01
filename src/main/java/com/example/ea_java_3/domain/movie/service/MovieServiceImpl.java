package com.example.ea_java_3.domain.movie.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.movie.dto.MovieDTO;
import com.example.ea_java_3.domain.movie.dto.MovieMapper;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.exceptions.CharacterNotFoundException;
import com.example.ea_java_3.exceptions.MovieNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepo;
    private final CharacterRepository characterRepository;
    private final MovieMapper mapper;

    public MovieServiceImpl(MovieRepository movieRepo, CharacterRepository charRepo, MovieMapper mapper) {
        this.movieRepo = movieRepo;
        this.mapper = mapper;
        this.characterRepository = charRepo;
    }

    @Override
    public Movie create(MovieDTO dto) {
        return movieRepo.save(mapper.toMovie(dto));
    }

    @Override
    public Movie getById(int id) {
        return movieRepo.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    @Override
    public void deleteById(int id) {
        movieRepo.deleteById(id);
    }

    @Override
    public Movie update(MovieDTO dto) {
        return movieRepo.save(mapper.toMovie(dto));
    }

    @Override
    public Movie replaceCharacters(int movieId, Set<Integer> characterIds) {
        Movie movie = this.getById(movieId);
        Set<Character> chars = characterIds.stream().map(charId -> characterRepository.findById(charId).orElseThrow(() -> new CharacterNotFoundException(charId))).collect(Collectors.toSet());
        movie.setCharacters(chars);
        return movieRepo.save(movie);
    }

    @Override
    public List<Character> getMovieCharacters(int id) {
        return characterRepository.findAllByMovieId(id);
    }
}
