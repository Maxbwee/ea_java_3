package com.example.ea_java_3.domain.movie.model;

import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150, nullable = false)
    private String title;
    private String genre;
    @Column(name = "release_year", length = 4, nullable = false)
    private int releaseYear;
    private String director;
    private String picture;
    private String trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany
    @JoinTable(
            name = "character_movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;
}
