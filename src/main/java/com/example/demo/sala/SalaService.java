package com.example.demo.sala;

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
public class SalaService {
    @Autowired
    private final SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    //GET
    public List<Sala> getSalas(){
        return salaRepository.findAll();
    }

    //POST
    public void addNewSala(Sala sala){
        salaRepository.save(sala);
    }

    //DELETE
    public void deleteSala(Long id){
        boolean exists = salaRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("La sala con id " + id + " esta llena");
        }
    }


}
