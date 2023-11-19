package com.example.demo.pelicula;

import java.sql.Date;
import jakarta.persistence.*;


import lombok.Data;
@Entity
@Table(name = "pelicula")
@Data
public class Pelicula {
    @Id // Establece el ID como llave primaria
    @Column(name = "id") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "pelicula_sequence", // Nombre del generador
        sequenceName = "pelicula_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "pelicula_sequence" // Nombre del generador
    )
    
    private int id;  // id de la pelicula
    private String nombre;  // nombre de la pelicula
    private int duracion;  // duracion de la pelicula
    private String genero;  // genero de la pelicula
    private String director;  // director de la pelicula
    private Date fechaEstreno;  // fecha de estreno de la pelicula
    
}
