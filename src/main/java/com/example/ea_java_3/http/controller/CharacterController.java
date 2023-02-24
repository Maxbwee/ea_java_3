package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.character.model.CharacterDTO;
import com.example.ea_java_3.domain.franchise.FranchiseService;
import com.example.ea_java_3.domain.franchise.model.FranchiseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "character") // Base URL
public class CharacterController {
    private final FranchiseService service;

    public CharacterController(FranchiseService service) {
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

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody CharacterDTO body) {
        return ResponseEntity.ok().body("ok");
    }

    @PutMapping("/")
    public ResponseEntity<String> update(@RequestBody CharacterDTO body) {
        return ResponseEntity.ok().body("ok");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok().body("ok");
    }
}
