package com.example.demo.sala;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Sala")
@Data
public class Sala {
    @Id // Establece el ID como llave primaria
    @Column(name = "id") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "sala_sequence", // Nombre del generador
        sequenceName = "sala_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "sala_sequence" // Nombre del generador
    )
    private Long id;
    
    
}
