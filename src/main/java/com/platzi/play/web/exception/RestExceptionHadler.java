package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlredyExistsException;
import com.platzi.play.domain.exception.MovieNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHadler {

    @ExceptionHandler(MovieAlredyExistsException.class)
    public ResponseEntity<Error> handleMovieAlredyExistsException(MovieAlredyExistsException e) {
        Error error = new Error("Movie-Alredy-Exists", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<Error> handleMovieNotExists(Exception e) {
        Error error = new Error("Movie-Not-Found", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> hadleException(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Error error = new Error("Validation-Error", fieldError.getDefaultMessage());
            errors.add(error);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception e) {
        Error error = new Error("Internal-Server-Error", e.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
