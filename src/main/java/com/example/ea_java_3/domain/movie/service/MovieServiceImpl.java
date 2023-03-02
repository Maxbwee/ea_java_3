package com.example.ea_java_3.domain.movie.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.movie.dto.MovieMapper;
import com.example.ea_java_3.domain.movie.dto.MoviePostDTO;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.exceptions.exc.ApiRuntimeException;
import com.example.ea_java_3.exceptions.exc.CharacterNotFoundException;
import com.example.ea_java_3.exceptions.exc.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public Movie create(MoviePostDTO dto) {
        Movie movie = mapper.toMovie(dto);
        movie.setCharacters(Set.of());
        return movieRepo.save(movie);
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
        movieRepo.findById(id).orElseThrow(() -> new ApiRuntimeException("Movie with this id does not exist."));
        movieRepo.deleteById(id);
    }

    @Override
    public Movie update(int id, MoviePostDTO dto) {
        Movie movie = mapper.toMovie(dto);
        movie.setId(id);
        movie.setCharacters(Set.of());
        return movieRepo.save(movie);
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
        List<Character> chars = characterRepository.findAll();
        chars.forEach(it -> {
            Set<Movie> movies = new HashSet<>(movieRepo.findAllByCharacterId(it.getId()));
            it.setMovies(movies);
        });
        return chars;
    }
}
