package com.example.ea_java_3.domain.franchise.model;

import com.example.ea_java_3.domain.movie.model.Movie;
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}
