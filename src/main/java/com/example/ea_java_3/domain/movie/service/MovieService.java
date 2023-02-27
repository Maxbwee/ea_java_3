package com.example.ea_java_3.domain.movie.service;

import com.example.ea_java_3.domain.movie.model.Movie;
import com.example.ea_java_3.domain.shared.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface MovieService extends CrudService<Movie, Integer> {

}
