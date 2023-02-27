package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.franchise.service.FranchiseService;
import com.example.ea_java_3.domain.franchise.model.FranchiseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "franchise") // Base URL
public class FranchiseController {
    private final FranchiseService service;

    public FranchiseController(FranchiseService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("{id}/movies")
    public ResponseEntity<String> getFranchiseMovies(@PathVariable String id) { return ResponseEntity.ok().body("ok");}

    @GetMapping("{id}/characters")
    public ResponseEntity<String> getFranchiseCharacters(@PathVariable String id) { return ResponseEntity.ok().body("ok");}

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody FranchiseDTO body) {
        return ResponseEntity.status(201).body("TODO");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody FranchiseDTO body) {
        return ResponseEntity.ok().body("ok");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok().body("ok");
    }
}
