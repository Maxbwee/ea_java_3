package com.example.ea_java_3.http.controller;


import com.example.ea_java_3.domain.movie.model.MovieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "movie") // Base URL
public class MovieController {

    @GetMapping("{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("{id}/characters")
    public ResponseEntity<String> getMovieCharacters(@PathVariable String id) {
        return ResponseEntity.ok().body("ok");
    }

    @PutMapping("{id}/characters")
    public ResponseEntity<String> updateMovieCharacters(@PathVariable String id) {
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody MovieDTO body) {
        return ResponseEntity.ok().body("ok");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody MovieDTO body) {
        return ResponseEntity.ok().body("ok");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok().body("ok");
    }
}
