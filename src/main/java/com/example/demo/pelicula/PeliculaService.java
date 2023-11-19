package com.example.demo.pelicula;
//Componentes de Spring
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.exceptionpelicula.ApiRequestExceptionPelicula;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//Componentes de Spring
import org.springframework.stereotype.Component;


@Component
public class PeliculaService {
    @Autowired
    private final PeliculaRepository peliculaRepository;
    

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    //GET
    public List<Pelicula> getPeliculas(){
        return peliculaRepository.findAll();
    }

    //POST  
    public void addNewPelicula(Pelicula pelicula){
        
        //Este metodo no se como se programaría para agregar una excepción por Id a la pelicula
        /*Boolean peliculaByHorario = peliculaRepository.findPeliculaById(pelicula.getId()); //Bussiness Logic

        if (validatePelicula(pelicula.getId()) == false) {
            throw new ApiRequestException("La película no esta en cartelera, revisa fecha de estreno u otra sucursal");
        }
        else if (peliculaByHorario) {
            throw new IllegalStateException("La pelicula ya esta en cartelera");
        }*/

        peliculaRepository.save(pelicula);
    }

    //DELETE
    public void deletePelicula(Long id){
        boolean exists = peliculaRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("La pelicula con id " + id + " no existe");
        }
        peliculaRepository.deleteById(id);
    }
    
    //Validar pelicula
    public void validatePelicula(Long id) {
         //Esto no se como se programaría
    }
}
