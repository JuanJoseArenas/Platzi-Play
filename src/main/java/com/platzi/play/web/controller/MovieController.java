package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.SuggestionRequestDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.service.MovieService;
import com.platzi.play.domain.service.PlatziPlayAiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAiService platziPlayAiService;

    public MovieController(MovieService movieService, PlatziPlayAiService platziPlayAiService) {
        this.movieService = movieService;
        this.platziPlayAiService = platziPlayAiService;
    }

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> movies = movieService.getAll();
        if (movies.isEmpty())
            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{idMovie}")
    public ResponseEntity<MovieDto> getById(@PathVariable long idMovie){
        MovieDto movieDto = movieService.getById(idMovie);
        if (movieDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
        MovieDto savedMovie = movieService.save(movieDto);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestionRequestDto suggestionRequestDto){
        return ResponseEntity.ok(this.platziPlayAiService.generateMovieSuggestion(suggestionRequestDto.userPreferences()));
    }

    @DeleteMapping("/{idMovie}")
     public ResponseEntity<Void> delete(@PathVariable long idMovie){
        movieService.delete(idMovie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{idMovie}")
    public ResponseEntity<UpdateMovieDto> update(@PathVariable long idMovie, @RequestBody UpdateMovieDto updateMovieDto){
        MovieDto updatedMovie = movieService.update(idMovie, updateMovieDto);
        if (updatedMovie == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updateMovieDto, HttpStatus.OK);
    }



}
