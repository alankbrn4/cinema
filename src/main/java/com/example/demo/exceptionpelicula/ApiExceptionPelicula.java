package com.example.demo.exceptionpelicula;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * La clase ApiException representa una excepción personalizada que se utiliza para manejar errores en la API.
 * Contiene información sobre el mensaje de error, la excepción original, el estado HTTP y la marca de tiempo.
 */
@Data
public class ApiExceptionPelicula {
    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

    public ApiExceptionPelicula(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }
}
