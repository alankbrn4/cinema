package com.example.demo.exception;


import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase que maneja las excepciones lanzadas en el tiempo de ejecución en la API.
 */
@ControllerAdvice ////Captura cualquer excepcion que sea lanzada en el tiempo de ejecución
public class ApiExceptionHandler {
    /**
     * Maneja las excepciones de tipo ApiRequestException.
     * @param e La excepcion ApiRequestException lanzada.
     * @return ResponseEntity  con los detalles de la excepción y el estado HTTP 400 Bad Request.
     */
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        // Paso 1. Se crea el payload que contiene los detalles de la excepción
        ApiException apiException = new ApiException(e.getMessage(), e, badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        //Paso 2. Se retorna la respuesta
        return new ResponseEntity<>(apiException, badRequest);
    }
}
