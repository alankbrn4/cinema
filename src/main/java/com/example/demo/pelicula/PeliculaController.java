package com.example.demo.pelicula;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.exceptionpelicula.ApiRequestExceptionPelicula;
import com.example.demo.usuarios.Usuario;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@RestController
@RequestMapping(path = "api/pelicula") // localhost:8080/api/pelicula
public class PeliculaController {

    //Se crea una instancia de la clase peliculaService
    @Autowired
    private final PeliculaService peliculaService;

    //Inyección de la dependencia peliculaService
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> getPelicula(){
        return peliculaService.getPeliculas();
    }

    @PostMapping
    public void registrarNuevaPelicula (@Validated @RequestBody Pelicula pelicula, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestExceptionPelicula("Pelicula No Registrada");
        }
        peliculaService.addNewPelicula(pelicula);
    }

    @DeleteMapping
    public void eliminarPelicula(Long id){
        
        peliculaService.deletePelicula(id);
    }
    
}
