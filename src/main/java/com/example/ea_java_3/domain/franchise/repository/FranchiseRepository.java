package com.example.ea_java_3.domain.franchise.repository;

import com.example.ea_java_3.domain.franchise.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> { }
