package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.persistence.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface MovieMapper {
    @Mappings(value = {
            @Mapping(source = "titulo", target = "title"),
            @Mapping(source = "duracion", target = "duration"),
            @Mapping(source = "genero", target = "genre",qualifiedByName = "stringToGenre"),
            @Mapping(source = "fechaEstreno", target = "releaseDate"),
            @Mapping(source = "clasificacion", target = "rating"),
    })

    MovieDto toDto(MovieEntity movieEntity);

    List<MovieDto> toDtos(Iterable<MovieEntity> movieEntities);

    @InheritInverseConfiguration
    @Mapping(source = "genre", target = "genero",qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto movieDto);
}
