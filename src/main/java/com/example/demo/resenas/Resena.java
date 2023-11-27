package com.example.demo.resenas;

import com.example.demo.usuarios.Usuario;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Reseñas")
@Data
public class Resena {
    @Id // Establece el ID como llave primaria
    @Column(name = "id_resena") // Establece el nombre de la columna
    @SequenceGenerator( // Genera un valor secuencial
        name = "reseñas_sequence", // Nombre del generador
        sequenceName = "reseñas_sequence", // Nombre de la secuencia
        allocationSize = 1 // Cantidad de valores a generar
    )

    @GeneratedValue( // Genera un valor único
        strategy = GenerationType.SEQUENCE, // Estrategia de generación
        generator = "reseñas_sequence" // Nombre del generador
    )
    private Long id;
    private float calificacion;
    private String reseña;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    
}
