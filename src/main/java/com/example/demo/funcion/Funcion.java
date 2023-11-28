package com.example.demo.funcion;

import com.example.demo.sala.Sala;
import com.example.demo.cartelera.Cartelera;

import jakarta.persistence.*;


import lombok.Data;
import java.util.Date;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "Funcion")
@Data
public class Funcion {
    @Id // Establece el ID como llave primaria
    @Column(name = "id_funcion") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "funcion_sequence", // Nombre del generador
        sequenceName = "funcion_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "funcion_sequence" // Nombre del generador
    )

    private Long id;  // id de la funcion
    private Date horarioInicio;  // horario de inicio de la funcion
    private Date horarioFin;  // horario de fin de la funcion

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "id_cartelera")
    private Cartelera cartelera;
}
