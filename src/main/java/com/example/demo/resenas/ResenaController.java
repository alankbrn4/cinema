package com.example.demo.resenas;

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
@RequestMapping(path = "api/resena") // localhost:8080/api/resena
public class ResenaController {

    //Creamos una instancia de la clase resenaService
    @Autowired
    private final ResenaService resenaService;

    //inyección de la dependencia resenaService
    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping
    public List<Resena> getResenas(){
        
        return resenaService.getResenas();
    }

    @PostMapping
    public void registrarNuevaResena(@Validated @RequestBody Resena resena, BindingResult bindingResult){
        
        resenaService.addNewResena(resena);
    }

    @DeleteMapping
    public void eliminarResena(Long id){
        
        resenaService.deleteResena(id);
    }
    
}
