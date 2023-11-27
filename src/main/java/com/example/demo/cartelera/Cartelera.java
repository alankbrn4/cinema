package com.example.demo.cartelera;


import jakarta.persistence.*;

import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Cartelera")
@Data
public class Cartelera {
    @Id // Establece el ID como llave primaria
    @Column(name = "id_cartelera") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "cartelera_sequence", // Nombre del generador
        sequenceName = "cartelera_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "cartelera_sequence" // Nombre del generador
    )
    private Long id;
    private Date dia;
}
