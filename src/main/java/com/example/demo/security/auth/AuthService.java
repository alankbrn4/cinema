package com.example.demo.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.security.UserRepository;
import com.example.demo.usuarios.Usuario;
import com.example.demo.usuarios.UsuarioRepository;
import com.example.demo.security.Role;
import java.util.regex.Pattern;

import lombok.RequiredArgsConstructor;

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
        Usuario user = new Usuario();
        
        user = Usuario.builder()
        .nombre(request.getNombre())
        .edad(request.getEdad())
        .email(request.getEmail())
        .genero(request.getGenero())
        .admin(false)
        .password(passwordEncoder.encode(request.getPassword()))
        .role(AssignRole(request.getEmail()))
        .build();

        userRepository.save(user);
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
