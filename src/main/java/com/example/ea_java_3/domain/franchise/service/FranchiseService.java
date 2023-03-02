package com.example.ea_java_3.domain.franchise.service;


import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.franchise.dto.FranchisePostDTO;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.dto.FranchiseDTO;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.shared.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface FranchiseService extends CrudService<Franchise, FranchisePostDTO> {
    List<Movie> getFranchiseMovies(int id);
    List<Character> getFranchiseCharacters(int id);

    Franchise replaceMovies(int franchiseId, Set<Integer> movieIds);
}
