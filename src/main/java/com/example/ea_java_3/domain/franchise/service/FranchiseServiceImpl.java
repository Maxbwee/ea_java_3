package com.example.ea_java_3.domain.franchise.service;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.repository.CharacterRepository;
import com.example.ea_java_3.domain.franchise.dto.FranchiseMapper;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.dto.FranchiseDTO;
import com.example.ea_java_3.domain.franchise.repository.FranchiseRepository;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.exceptions.FranchiseNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Franchise create(FranchiseDTO dto) {
        Franchise obj = mapper.toFranchise(dto);
        // TODO Id null required?
        return franchiseRepository.save(obj);
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
        return charRepository.findAllByFranchiseId(id);
    }

    @Override
    public void deleteById(int id) {
         franchiseRepository.deleteById(id);
    }

    @Override
    public Franchise update(FranchiseDTO dto) {

        return null;
    }
}
