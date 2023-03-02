package com.example.ea_java_3.domain.franchise.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.Set;

@Data
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
    private Set<Integer> movieIds;
}