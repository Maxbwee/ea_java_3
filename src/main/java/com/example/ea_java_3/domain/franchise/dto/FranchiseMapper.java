package com.example.ea_java_3.domain.franchise.dto;


import com.example.ea_java_3.domain.franchise.model.Franchise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseDTO toFranchiseDto(Franchise franchise);
    Franchise toFranchise(FranchiseDTO dto);
}
