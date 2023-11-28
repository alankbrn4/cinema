package com.example.demo.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor  

public class RegistrationRequest {
    private String nombre;
    private int edad;
    private String email;
    private int genero;
    private String password;
}
