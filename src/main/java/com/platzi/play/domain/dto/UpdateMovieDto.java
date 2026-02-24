package com.platzi.play.domain.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,
        @PastOrPresent(message = "La fecha de lanzamiento no puede ser futura")
        LocalDate releaseDate,

        @Min(value = 0, message = "La calificación debe ser mayor o igual a 0")
        @Max(value = 5, message = "La calificación debe ser menor o igual a 5")
        Double rating
) {
}
