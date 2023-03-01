package com.example.ea_java_3.domain.movie.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.movie.dto.MovieDTO;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.shared.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MovieService extends CrudService<Movie, MovieDTO> {
    List<Character> getMovieCharacters(int id);
    Movie replaceCharacters(int movieId, Set<Integer> characterIds);
}
