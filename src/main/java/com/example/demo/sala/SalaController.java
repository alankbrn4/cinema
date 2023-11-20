package com.example.demo.sala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.usuarios.Usuario;
import com.example.demo.usuarios.UsuarioService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@RestController
@RequestMapping(path = "api/sala") // localhost:8080/api/sala
public class SalaController {
    //Creamos una instancia de la clase usuarioService
    @Autowired
    private final SalaService salaService;

    //inyección de la dependencia usuarioService
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public List<Sala> getSalas(){
        
        return salaService.getSalas();
    }

    @PostMapping
    public void registrarNuevaSala(@Validated @RequestBody Sala sala, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Sala ya Completa");//Esto hay que modificarlo a una nueva excepción personalizada para cuando la sala este llena
        }
        salaService.addNewSala(sala);
    }

    @DeleteMapping
    public void eliminarSala(Long id){
        
        salaService.deleteSala(id);
    }
}
