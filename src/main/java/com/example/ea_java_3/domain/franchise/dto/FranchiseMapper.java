package com.example.ea_java_3.domain.franchise.dto;


import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.service.MovieService;
import com.example.ea_java_3.domain.shared.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


@Mapper(componentModel = "spring")
public abstract class FranchiseMapper extends BaseMapper {
    @Mapping(source = "movies", target = "movieIds", qualifiedByName = "moviesToIds")
    public abstract FranchiseDTO toFranchiseDto(Franchise franchise);

    @Mapping(source = "movieIds", target = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Franchise toFranchise(FranchiseDTO dto);

    public abstract Franchise toFranchise(FranchisePostDTO dto);
}

