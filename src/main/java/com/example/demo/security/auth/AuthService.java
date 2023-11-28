package com.example.demo.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.usuarios.UsuarioRepository;
import com.example.demo.security.Role;
import java.util.regex.Pattern;
import com.example.demo.security.config.JwtService;
import com.example.demo.usuarios.Usuario;

import lombok.RequiredArgsConstructor;

/**
 * Esta clase es responsable de manejar la autenticación y registro de usuarios.
 * Utiliza un objeto UserRepository para interactuar con la base de datos y un objeto PasswordEncoder para encriptar las contraseñas de los usuarios.
 * También utiliza un objeto JwtService para generar tokens JWT y un objeto AuthenticationManager para autenticar a los usuarios.
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService JwtService;

    @Autowired  
    private AuthenticationManager authenticationManager;

    //Este método registra a un nuevo usuario en la base de datos.
    public AuthenticationResponse register(RegistrationRequest request) {
               
        var user = Usuario.builder()
        .nombre(request.getNombre())
        .edad(request.getEdad())
        .email(request.getEmail())
        .genero(request.getGenero())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();

        userRepository.save(user);
        var jwtToken = JwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUsuarioByEmail(request.getEmail())
        .orElseThrow();

        var jwtToken = JwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    
    private Role AssignRole(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@cinemaJunky\\.com\\b";

        if (Pattern.matches(regex, email)) {
            return Role.ADMIN;
        } else {
            return Role.USER;
        }
    }
    
}
