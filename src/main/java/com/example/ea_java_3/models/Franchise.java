package com.example.ea_java_3.models;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 1000)
    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
