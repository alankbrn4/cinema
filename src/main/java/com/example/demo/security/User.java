package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.security.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;

@Entity
// tag para indicar que la clase "User" se relaciona con una tabla de una base de datos
@Builder
// tag contrusctor que permite crear el objeto "User" creando una cadena de métodos con una cadena de propiedades

    public class User implements UserDetails {

        @Id /*Tag del primary key */
        @SequenceGenerator(  /*tag que genera una de valores únicos para "id" */
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
        )

        @GeneratedValue( 
            // tag para generar el valor automático de "id" por JPA
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
        )
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        @Enumerated(EnumType.STRING)
        // Atributos del usario
        public Role role;

        public User() {
            // Constructor vacio
                    }
                
        public User(long id, String firstName, String lastName, String email, String password, Role role) {
            // Constructor con parámetros
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.role = role;
        }

        public long getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getFirstName() {
            return firstName;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public String getLastName() {
            return lastName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(new SimpleGrantedAuthority(role.name()));
        }

        @Override
        public String getUsername () {
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
