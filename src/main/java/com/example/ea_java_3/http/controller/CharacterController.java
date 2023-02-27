package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.character.model.CharacterDTO;
import com.example.ea_java_3.domain.character.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "character") // Base URL
public class CharacterController {
    
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @Operation(summary = "Get all characters by Id")
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
