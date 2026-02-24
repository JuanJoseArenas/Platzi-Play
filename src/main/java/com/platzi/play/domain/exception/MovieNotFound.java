package com.platzi.play.domain.exception;

public class MovieNotFound extends RuntimeException {

    public MovieNotFound(long title) {
        super("La película con el título " + title + " no existe.");
    }
}
