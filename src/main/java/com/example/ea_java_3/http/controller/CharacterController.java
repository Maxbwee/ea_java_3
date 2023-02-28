package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.character.dto.CharacterDTO;
import com.example.ea_java_3.domain.character.dto.CharacterMapper;
import com.example.ea_java_3.domain.character.service.CharacterService;
import com.example.ea_java_3.exceptions.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "character") // Base URL
public class CharacterController {
    
    private final CharacterService service;
    private final CharacterMapper mapper;
    public CharacterController(CharacterService service, CharacterMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Get all characters by Id")
    @GetMapping("{id}")
    public ResponseEntity<String> getById(@PathVariable int id) {
        return ResponseEntity.ok().body("ok");
    }

    @Operation(summary = "Get all characters")
    @ApiResponses(
            value =  {
            @ApiResponse(
                responseCode = "200",
                description = "Success",
                content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class))
                    )
                }
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Character does not exist with id",
                content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)
                    )
                }
            )
        }
    )
    @GetMapping("/")
    public ResponseEntity<String> getAll() {
        List<CharacterDTO> characters = mapper.toCharacterDto()
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
