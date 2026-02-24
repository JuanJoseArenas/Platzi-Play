package com.platzi.play.domain.exception;

public class MovieAlredyExistsException extends RuntimeException {

    public MovieAlredyExistsException(String title) {
        super("La película con el título " + title + " ya existe.");
    }
}
