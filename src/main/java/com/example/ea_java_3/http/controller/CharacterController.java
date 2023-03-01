package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.character.dto.CharacterDTO;
import com.example.ea_java_3.domain.character.dto.CharacterMapper;
import com.example.ea_java_3.domain.character.model.Character;
import com.example.ea_java_3.domain.character.service.CharacterService;
import com.example.ea_java_3.exceptions.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("{id}")
    @Operation(summary = "Get all characters by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                description = "Success",
                content = { @Content(mediaType = "application/json",
                array= @ArraySchema(schema = @Schema(implementation = CharacterDTO.class))
                )}
            ),
            @ApiResponse(responseCode = "404",
                description = "Character does not exist with this ID",
                content = { @Content(mediaType = "application/json",
                schema = @Schema(implementation = ApiErrorResponse.class))}
            )
    })
    public ResponseEntity<CharacterDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(mapper.toCharacterDto(service.getById(id)));
    }

    @GetMapping("/")
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
    public ResponseEntity<List<CharacterDTO>> getAll() {
        List<CharacterDTO> characters = service.getAll().stream().map(mapper::toCharacterDto).toList();
        return ResponseEntity.ok(characters);
    }

    @PostMapping("/")
    @Operation(summary = "Adds a new Character")
    public ResponseEntity<String> create(@RequestBody CharacterDTO body) {
        Character character = service.create(body);
        URI location = URI.create("characters/" + character.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                description = "Chracter succesfully updated",
                content = @Content
            ),
            @ApiResponse(responseCode = "400",
                description = "Bad request",
                content = { @Content (mediaType = "application/json",
                schema = @Schema(implementation = ErrorAttributeOptions.class)
                )}
            ),
            @ApiResponse(responseCode = "404",
                description = "Character not found with that ID",
                content = @Content)
    })
    public ResponseEntity<CharacterDTO> update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        if(id != characterDTO.getId()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(mapper.toCharacterDto(service.update(characterDTO)));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletes character by IDs")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
