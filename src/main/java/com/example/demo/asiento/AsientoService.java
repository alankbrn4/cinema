package com.example.demo.asiento;

//Componentes de Spring
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.sala.Sala;
import com.example.demo.sala.SalaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class AsientoService {
    @Autowired
    private final AsientoRepository asientoRepository;

    public AsientoService(AsientoRepository asientoRepository) {
        this.asientoRepository = asientoRepository;
    }

    //GET
    public List<Asiento> getAsiento(){
        return asientoRepository.findAll();
    }

    //POST
    public void addNewAsiento(Asiento asiento){
        asientoRepository.save(asiento);
    }

    //DELETE
    public void deleteAsiento(Long id){
        boolean exists = asientoRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("El Asiento con id " + id + " esta ocupado");
        }
    }
}
