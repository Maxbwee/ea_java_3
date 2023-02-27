package com.example.ea_java_3.domain.movie.model;

import lombok.Data;

@Data
public class MovieDTO {
    private int id;
    private String title;

    private String genre;
    private int releaseYear;
    private String director;
    private String picture;
    private String trailer;
}
