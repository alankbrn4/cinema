package com.example.demo.exceptionpelicula;

public class ApiRequestExceptionPelicula extends RuntimeException{

    /**
     * Constructor que toma un mensaje de error como parámetro.
     * @param message El mensaje de error que se mostrará cuando se lance la excepción.
     */
    public ApiRequestExceptionPelicula(String message) {
        super(message);
    }

    /**
     * Constructor que toma un mensaje de error y una causa como parámetros.
     * @param message El mensaje de error que se mostrará cuando se lance la excepción.
     * @param cause La causa subyacente de la excepción.
     */
    public ApiRequestExceptionPelicula(String message, Throwable cause){
        super(message, cause);
    }
}