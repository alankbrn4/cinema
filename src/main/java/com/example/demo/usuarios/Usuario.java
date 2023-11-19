package com.example.demo.usuarios;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class Usuario {
    @Id // Establece el ID como llave primaria
    @Column(name = "id") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "usuarios_sequence", // Nombre del generador
        sequenceName = "usuarios_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "usuarios_sequence" // Nombre del generador
    )
    private Long id;
    private String nombre;
    private int edad;
    private String email;
    private int genero;
    private boolean admin;
}
