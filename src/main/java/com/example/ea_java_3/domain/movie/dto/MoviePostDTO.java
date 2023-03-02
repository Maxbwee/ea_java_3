package com.example.ea_java_3.domain.movie.dto;

import lombok.Data;

@Data
public class MoviePostDTO {
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String picture;
    private String trailer;
    private int franchiseId;
}
