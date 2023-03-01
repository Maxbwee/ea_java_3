package com.example.ea_java_3.http.controller;

import com.example.ea_java_3.domain.character.dto.CharacterDTO;
import com.example.ea_java_3.domain.character.dto.CharacterMapper;
import com.example.ea_java_3.domain.franchise.dto.FranchiseMapper;
import com.example.ea_java_3.domain.franchise.model.Franchise;
import com.example.ea_java_3.domain.franchise.service.FranchiseService;
import com.example.ea_java_3.domain.franchise.dto.FranchiseDTO;
import com.example.ea_java_3.domain.movie.dto.MovieDTO;
import com.example.ea_java_3.domain.movie.dto.MovieMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "franchise") // Base URL
public class FranchiseController {
    private final FranchiseService service;
    private final FranchiseMapper mapper;
    private final CharacterMapper charMapper;
    private final MovieMapper movieMapper;

    public FranchiseController(
            @Qualifier("franchiseServiceImpl") FranchiseService service,
            FranchiseMapper mapper,
            CharacterMapper charMapper,
            MovieMapper movieMapper
    ) {
        this.service = service;
        this.mapper = mapper;
        this.charMapper = charMapper;
        this.movieMapper = movieMapper;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a franchise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class)
                    )}
            ),
            @ApiResponse(responseCode = "404",
                    description = "Franchise does not exist with this ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponse.class))}
            )
    })
    public ResponseEntity<FranchiseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok().body(mapper.toFranchiseDto(service.getById(id)));
    }

    @GetMapping("/")
    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = FranchiseDTO.class))
                    )}
            )
    })
    public ResponseEntity<List<FranchiseDTO>> getAll() {
        List<FranchiseDTO> franchises = service.getAll().stream().map(mapper::toFranchiseDto).collect(Collectors.toList());
        return ResponseEntity.ok().body(franchises);
    }

    @GetMapping("/{id}/movies")
    @Operation(summary = "Get all movies belonging to a franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = MovieDTO.class))
                    )}
            )
    })
    public ResponseEntity<List<MovieDTO>> getFranchiseMovies(@PathVariable int id) {
        List<MovieDTO> movies = service.getFranchiseMovies(id).stream().map(movieMapper::toMovieDto).toList();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping("/{id}/characters")
    @Operation(summary = "Get all characters belonging to a franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class))
                    )}
            )
    })
    public ResponseEntity<List<CharacterDTO>> getFranchiseCharacters(@PathVariable int id) {
        List<CharacterDTO> chars = service.getFranchiseCharacters(id).stream().map(charMapper::toCharacterDto).toList();
        return ResponseEntity.ok().body(chars);
    }

    @PostMapping("/")
    @Operation(summary = "Create a new franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class)
                    )}
            )
    })
    public ResponseEntity<FranchiseDTO> create(@RequestBody FranchiseDTO body) {
        return ResponseEntity.created(URI.create("TODO")).body(mapper.toFranchiseDto(service.create(body)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class)
                    )}
            )
    })
    public ResponseEntity<FranchiseDTO> update(@RequestBody FranchiseDTO body, @PathVariable int id) {
        body.setId(id);
        return ResponseEntity.ok().body(mapper.toFranchiseDto(service.update(body)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a new franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Integer.class)
                    )}
            )
    })
    public ResponseEntity<Integer> delete(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("{id}/movies")
    public ResponseEntity<FranchiseDTO> updateFranchiseMovies(@RequestBody Set<Integer> movieIds, @PathVariable int id) {
        Franchise franchise = service.replaceMovies(id, movieIds);
        return ResponseEntity.ok().body(mapper.toFranchiseDto(franchise));
    }
}
