package com.example.ea_java_3.domain.franchise.model;

import com.example.ea_java_3.domain.movie.model.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
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
