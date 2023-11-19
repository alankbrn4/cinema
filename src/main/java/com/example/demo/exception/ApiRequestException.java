package com.example.demo.exception;

public class ApiRequestException extends RuntimeException{

    /**
     * Constructor que toma un mensaje de error como parámetro.
     * @param message El mensaje de error que se mostrará cuando se lance la excepción.
     */
    public ApiRequestException(String message) {
        super(message);
    }

    /**
     * Constructor que toma un mensaje de error y una causa como parámetros.
     * @param message El mensaje de error que se mostrará cuando se lance la excepción.
     * @param cause La causa subyacente de la excepción.
     */
    public ApiRequestException(String message, Throwable cause){
        super(message, cause);
    }
}
