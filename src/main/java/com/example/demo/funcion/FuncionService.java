package com.example.demo.funcion;

//Componentes de Spring
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class FuncionService {

    @Autowired
    private final FuncionRepository funcionRepository;

    public FuncionService(FuncionRepository funcionRepository){
        this.funcionRepository = funcionRepository;
    }

    //GET
    public List<Funcion> getFunciones(){
        return funcionRepository.findAll();
    }
    
    //POST
    public void addNewFuncion(Funcion funcion){
        funcionRepository.save(funcion);
    }

    //DELETE    
    public void deleteFuncion(Long id){
        boolean exists = funcionRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("La funcion con id " + id + " no esta disponible");
        }
        funcionRepository.deleteById(id);
    }
}
