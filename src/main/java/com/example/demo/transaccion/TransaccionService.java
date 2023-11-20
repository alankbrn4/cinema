package com.example.demo.transaccion;

//Componentes de Spring
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.sala.Sala;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class TransaccionService {
    @Autowired
    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }
    
    //GET
    public List<Transaccion> getTransaccion(){
        return transaccionRepository.findAll();
    }

    //POST
    public void addNewTransaccion(Transaccion transaccion){
        transaccionRepository.save(transaccion);
    }

    //DELETE
    public void deleteTransaccion(Long id){
        boolean exists = transaccionRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("La transacción con id " + id + " no existe");
        }
    }
}
