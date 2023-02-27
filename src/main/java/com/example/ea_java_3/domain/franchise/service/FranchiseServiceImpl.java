package com.example.ea_java_3.domain.franchise.service;

import com.example.ea_java_3.domain.franchise.dto.FranchiseMapper;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.dto.FranchiseDTO;
import com.example.ea_java_3.domain.franchise.repository.FranchiseRepository;
import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.movie.repository.MovieRepository;
import com.example.ea_java_3.exceptions.FranchiseNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private final FranchiseMapper mapper;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepo, FranchiseMapper mapper, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepo;
        this.mapper = mapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public Franchise create(FranchiseDTO dto) {
        Franchise obj = mapper.toFranchise(dto);
        // TODO Id null required?
        return franchiseRepository.save(obj);
    }

    @Override
    public Franchise getById(int id) {
        return franchiseRepository.findFranchiseById(id)
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
        return null;
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
