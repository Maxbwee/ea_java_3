package com.example.ea_java_3.domain.movie.dto;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.service.CharacterService;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.repository.FranchiseRepository;
import com.example.ea_java_3.domain.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class MovieMapper  {
    @Autowired
    private FranchiseRepository franchiseRepository;

    @Autowired
    private CharacterService characterService;

    @Mapping(source = "franchise", target ="franchiseId", qualifiedByName = "franchiseToId")
    @Mapping(source = "characters", target = "characterIds", qualifiedByName = "charactersToIds")
    public abstract MovieDTO toMovieDto(Movie movie);

    @Mapping(target = "franchise", source ="franchiseId", qualifiedByName = "franchiseIdToFranchise")
    @Mapping(target = "characters", source = "characterIds", qualifiedByName = "characterIdsToCharacters")
    public abstract Movie toMovie(MovieDTO movieDto);


    @Named("franchiseIdToFranchise")
    public Franchise franchiseIdToFranchise(Integer id) {
        return franchiseRepository.findById(id).get();
    }

    @Named("franchiseToId")
    public Integer franchiseToId(Franchise franchise) {
        return franchise.getId();
    }

    @Named("characterIdsToCharacters")
    public Set<Character> characterIdsToCharacters(Set<Integer> ids) {
        return ids.stream().map(characterService::getById).collect(Collectors.toSet());
    }

    @Named("charactersToIds")
    public Set<Integer> charactersToIds(Set<Character> characters) {
        return characters.stream().map(Character::getId).collect(Collectors.toSet());
    }
}
