package com.example.demo.usuarios;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    String email = "unitaryTest@mail.com";

    @AfterAll
    private void tearDown() {
        usuarioRepository.deleteAll();
    }

    @Test
    private void findUsuarioByEmail(){
        //Dados los parámetros de un usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("David");
        usuario.setEdad(37);
        usuario.setEmail(email);
        usuario.setGenero(1);
        usuario.setAdmin(false);

        usuarioRepository.save(usuario);

        //When
        boolean expected = usuarioRepository.findUsuarioByEmail(email);

        //Then
        assertTrue(expected);
    }
}
