package com.example.ea_java_3.domain.movie.dto;

import com.example.ea_java_3.domain.movie.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDTO toMovieDto(Movie movie);

    Movie toMovie(MovieDTO movieDto);
}
