package com.example.ea_java_3.domain.franchise.service;


import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.model.FranchiseDTO;
import com.example.ea_java_3.domain.franchise.repository.FranchiseRepository;
import com.example.ea_java_3.domain.shared.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Should this be Extends CrudService?
// In hibernate the service should be Interface I think. Not too sure.
// It creates a problem though with the methods in the class
// Didn't change anything yet, but I think we might need to put these methods into the
// FranchiseServiceImpl java class ?
@Service
public interface FranchiseService extends CrudService<Franchise, FranchiseDTO> {

    // Something to be added?
}
