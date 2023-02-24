package com.example.ea_java_3.domain.franchise;


import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.model.FranchiseDTO;
import com.example.ea_java_3.domain.shared.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseService implements CrudService<Franchise, FranchiseDTO> {
    private final FranchiseRepository repo;

    public FranchiseService(FranchiseRepository repo) {
        this.repo = repo;
    }

    @Override
    public Franchise create(FranchiseDTO dto) {
        // Transform obj
        return null;
    }

    @Override
    public Optional<Franchise> getById(int id) {
        return repo.findFranchiseById(id);
    }

    @Override
    public List<Franchise> getAll() {
        return repo.findAll();
    }

    @Override
    public Franchise deleteById(int id) {
        Optional<Franchise> result = repo.deleteFranchiseById(id);
        if (result.isEmpty()) {
            throw new RuntimeException("Franchise with this id not found");
        }
        return result.get();
    }

    @Override
    public Franchise update(FranchiseDTO dto) {
        return null;
    }
}
