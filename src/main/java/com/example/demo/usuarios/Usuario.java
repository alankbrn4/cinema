package com.example.demo.usuarios;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.security.Role;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class Usuario implements UserDetails {
    @Id // Establece el ID como llave primaria
    @Column(name = "id_usuario") // Establece el nombre de la columna
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
    private String password;

    @Enumerated(EnumType.STRING)
    Role role;
    
    
    //Métodos de UserDetails
    @Override //Arroja el tipo de usuario
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override //Arroja el nombre de usuario, el correo en nuestro caso
    public String getUsername() { //Subject
        return email;
    }
    
    @Override //Arroja el estado de la cuenta
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override //Arroja el estado de la cuenta   
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override //Arroja el estado de la cuenta
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override //Arroja el estado de la cuenta
    public boolean isEnabled() {
        return true;
    }
}
