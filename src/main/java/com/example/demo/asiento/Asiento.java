package com.example.demo.asiento;
import com.example.demo.sala.Sala;
import com.example.demo.usuarios.Usuario;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Asiento")
@Data
public class Asiento {
    @Id // Establece el ID como llave primaria
    @Column(name = "id_asiento") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "asiento_sequence", // Nombre del generador
        sequenceName = "asiento_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "asiento_sequence" // Nombre del generador
    )

    private Long id;  // id del asiento
    private String fila;  // fila del asiento
    private int numAsiento;  // numero del asiento
    private boolean ocupado;  // si el asiento esta ocupado o no

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
}
