package com.example.ea_java_3.domain.character.dto;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.domain.movie.service.MovieService;
import com.example.ea_java_3.domain.shared.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class CharacterMapper {
    @Autowired
    private MovieRepository movieRepository;

    @Mapping(target = "movieIds", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDTO toCharacterDto(Character character);

    @Mapping(target = "movies", source="movieIds", qualifiedByName = "movieIdsToMovies")
    public abstract Character toCharacter(CharacterDTO characterDTO);

    @Named("movieIdsToMovies")
    public Set<Movie> movieIdsToMovies(Set<Integer> ids) {
        System.out.println("AAAAAA" + ids);
        return ids.stream().map(it -> movieRepository.findById(it).get()).collect(Collectors.toSet());
    }

    @Named("moviesToIds")
    public Set<Integer> moviesToIds(Set<Movie> movies) {
        System.out.println("BBBBBBBBBBBBB" + movies);
        return movies.stream().map(Movie::getId).collect(Collectors.toSet());
    }
}
