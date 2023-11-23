package com.example.demo.usuarios;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.List;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService undertest;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        undertest = new UsuarioService(usuarioRepository);
    }

    @Test
    void testGetUsuarios() {
        //Dado el parámetro de un usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("David");     
        usuario.setEdad(37);
        usuario.setEmail("alan@gmail.com");     
        usuario.setGenero(1);
        usuario.setAdmin(false);

        
        undertest.addNewUsuario(usuario);
        Mockito.when(usuarioRepository.findAll()).thenReturn(List.of(usuario));

        // Cuando se ejecute el método getUsuarios
        List<Usuario> expectedOutput = undertest.getUsuarios();

        // Debe pasar esto
        assert(expectedOutput).equals(List.of(usuario));
        
    }

    @Test
    void testAddUsuario() {
        //Dado el parámetro de un usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Ana");     
        usuario.setEdad(32);
        usuario.setEmail("amedina@gmail.com");
        usuario.setGenero(0);
        usuario.setAdmin(false);    
        

        //Cuando se ejecute el método addUsuario
        undertest.addNewUsuario(usuario);

        ArgumentCaptor<Usuario> captureUsuario = ArgumentCaptor.forClass(Usuario.class);
        verify(usuarioRepository).save(captureUsuario.capture());

        Usuario capturedUsuario = captureUsuario.getValue();
        // Debe pasar esto
        assert(capturedUsuario).equals(usuario);
    }
    
}
