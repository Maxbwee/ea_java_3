package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.character.model.CharacterDTO;
import com.example.ea_java_3.domain.franchise.dto.FranchiseMapper;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.service.FranchiseService;
import com.example.ea_java_3.domain.franchise.dto.FranchiseDTO;
import com.example.ea_java_3.domain.movie.model.MovieDTO;
import lombok.val;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "franchise") // Base URL
public class FranchiseController {
    private final FranchiseService service;
    private final FranchiseMapper mapper;

    public FranchiseController(@Qualifier("franchiseServiceImpl") FranchiseService service, FranchiseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("{id}")
    public ResponseEntity<FranchiseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(mapper.toFranchiseDto(service.getById(id)));
    }

    @GetMapping("/")
    public ResponseEntity<List<FranchiseDTO>> getAll() {
        List<FranchiseDTO> franchises = service.getAll().stream().map(mapper::toFranchiseDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(franchises);
    }

    @GetMapping("{id}/movies")
    public ResponseEntity<List<MovieDTO>> getFranchiseMovies(@PathVariable int id) {
        throw new RuntimeException("todo");
    }

    @GetMapping("{id}/characters")
    public ResponseEntity<List<CharacterDTO>> getFranchiseCharacters(@PathVariable int id) {
        throw new RuntimeException("todo");
    }

    @PostMapping("/")
    public ResponseEntity<FranchiseDTO> create(@RequestBody FranchiseDTO body) {
        return ResponseEntity.created(URI.create("TODO")).body(mapper.toFranchiseDto(service.create(body)));
    }

    @PutMapping("/")
    public ResponseEntity<FranchiseDTO> update(@RequestBody FranchiseDTO body) {
        return ResponseEntity.ok().body(mapper.toFranchiseDto(service.update(body)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.ok().body("DELETED");
    }
}
