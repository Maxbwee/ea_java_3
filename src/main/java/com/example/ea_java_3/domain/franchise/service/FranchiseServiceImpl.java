package com.example.ea_java_3.domain.franchise.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.franchise.dto.FranchiseMapper;
import com.example.ea_java_3.domain.franchise.dto.FranchisePostDTO;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.repository.FranchiseRepository;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.exceptions.exc.FranchiseNotFoundException;
import com.example.ea_java_3.exceptions.exc.MovieNotFoundException;
import com.example.ea_java_3.exceptions.exc.MoviesInFranchiseException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    private final CharacterRepository charRepository;
    private final FranchiseMapper mapper;

    public FranchiseServiceImpl(
            FranchiseMapper mapper,
            FranchiseRepository franchiseRepo,
            MovieRepository movieRepo,
            CharacterRepository charRepo
    ) {
        this.mapper = mapper;
        this.franchiseRepository = franchiseRepo;
        this.movieRepository = movieRepo;
        this.charRepository = charRepo;
    }

    @Override
    public Franchise create(FranchisePostDTO dto) {
        Franchise f = mapper.toFranchise(dto);
        f.setMovies(Set.of());
        return franchiseRepository.save(f);
    }

    @Override
    public Franchise getById(int id) {
        return franchiseRepository.findById(id)
                .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    public List<Franchise> getAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public List<Movie> getFranchiseMovies(int id) {
        return movieRepository.findAllByFranchiseId(id);
    }

    @Override
    public List<Character> getFranchiseCharacters(int id) {
        List<Character> chars = charRepository.findAllByFranchiseId(id);
        chars.forEach(it -> {
            Set<Movie> movies = new HashSet<>(movieRepository.findAllByCharacterId(id));
            it.setMovies(movies);
        });
        return chars;
    }

    @Override
    public void deleteById(int id) {
        List<Movie> movies = movieRepository.findAllByFranchiseId(id);
        if (!movies.isEmpty()) {
            throw new MoviesInFranchiseException(movies.size());
        }
        franchiseRepository.deleteById(id);
    }

    @Override
    public Franchise update(int id, FranchisePostDTO dto) {
        if (franchiseRepository.findById(id).isEmpty()) {
            throw new FranchiseNotFoundException(id);
        }
        Franchise f = mapper.toFranchise(dto);
        f.setId(id);
        f.setMovies(Set.of());
        return franchiseRepository.save(f);
    }


    @Override
    public Franchise replaceMovies(int franchiseId, Set<Integer> movieIds) {
        Franchise franchise = this.getById(franchiseId);
        Set<Movie> movies = movieIds.stream().map(movId -> movieRepository.findById(movId).orElseThrow(() -> new MovieNotFoundException(movId))).collect(Collectors.toSet());
        franchise.setMovies(movies);
        return franchiseRepository.save(franchise);
    }
}
