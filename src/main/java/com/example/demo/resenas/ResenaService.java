package com.example.demo.resenas;

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
public class ResenaService {
    @Autowired
    private final ResenaRepository resenaRepository;

    public ResenaService(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    //GET
    public List<Resena> getResenas(){
        return resenaRepository.findAll();
    }

    //POST
    public void addNewResena(Resena resena){
        resenaRepository.save(resena);
    }

    //DELETE
    public void deleteResena(Long id){
        boolean exists = resenaRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("La reseña con id " + id + " no existe");
        }
        resenaRepository.deleteById(id);
    }
    
}
