package com.example.demo.usuarios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiRequestException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@RestController
@RequestMapping(path = "api/usuario") // localhost:8080/api/usuario 
public class UsuarioController {
    
    //Creamos una instancia de la clase usuarioService
    @Autowired
    private final UsuarioService usuarioService;

    //inyección de la dependencia usuarioService
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public void registrarNuevoUsuario(@Validated @RequestBody Usuario usuario, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Datos invalidos");
        }
        usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping
    public void eliminarUsuario(Long id){
        
        usuarioService.deleteUsuario(id);
    }
}
