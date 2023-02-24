package com.example.ea_java_3.domain.franchise.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
    private Set<Integer> movieIds;
}