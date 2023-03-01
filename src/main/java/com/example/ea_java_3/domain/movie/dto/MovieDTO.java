package com.example.ea_java_3.domain.movie.dto;

import lombok.Data;

import java.util.Set;

@Data
public class MovieDTO {
    private int id;
    private String title;

    private String genre;
    private int releaseYear;
    private String director;
    private String picture;
    private String trailer;
    private int franchiseId;
    private Set<Integer> characterIds;
}
