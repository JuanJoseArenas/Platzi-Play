package com.platzi.play.domain.repository;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);

    MovieDto update(long id, UpdateMovieDto updateMovieDto);

    void delete(long id);
}
