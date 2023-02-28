package com.example.ea_java_3.domain.character.model;

import com.example.ea_java_3.domain.movie.model.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100)
    private String alias;
    @Column(length = 20)
    private String gender;
    private String picture;

    @ManyToMany
    private Set<Movie> movies;
}
