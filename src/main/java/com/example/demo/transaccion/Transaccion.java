package com.example.demo.transaccion;

import com.example.demo.funcion.Funcion;
import com.example.demo.asiento.Asiento;
import java.util.List;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Transacciones")
@Data

public class Transaccion {
    @Id // Establece el ID como llave primaria
    @Column(name = "id_transaccion") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "transacciones_sequence", // Nombre del generador
        sequenceName = "transacciones_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "transacciones_sequence" // Nombre del generador
    )
    private Long id;
    private boolean pago;

    @OneToOne
    @JoinColumn(name = "id_funcion")
    private Funcion funcion;

    @OneToMany
    @JoinColumn(name = "id_asiento")
    private List<Asiento> asientos;
}
