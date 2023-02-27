package com.example.ea_java_3.domain.franchise.service;

import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.model.FranchiseDTO;
import com.example.ea_java_3.domain.franchise.repository.FranchiseRepository;
import com.example.ea_java_3.exceptions.FranchiseNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepo;
    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    public FranchiseServiceImpl(FranchiseRepository franchiseRepo) {
        this.franchiseRepo = franchiseRepo;
    }

    @Override
    public Franchise create(FranchiseDTO dto) {
        return null;
    }

    @Override
    public Franchise getById(int id) {
        return franchiseRepo.findFranchiseById(id)
                .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    public List<Franchise> getAll() {
        return null;
    }

    @Override
    public Franchise deleteById(int id) {
        return null;
    }

    @Override
    public Franchise update(FranchiseDTO dto) {
        return null;
    }
}
