package com.example.demo.cartelera;

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
public class CarteleraService {
    
        @Autowired
        private final CarteleraRepository carteleraRepository;
    
        public CarteleraService(CarteleraRepository carteleraRepository){
            this.carteleraRepository = carteleraRepository;
        }
    
        //GET
        public List<Cartelera> getCarteleras(){
            return carteleraRepository.findAll();
        }
        
        //POST
        public void addNewCartelera(Cartelera cartelera){
            carteleraRepository.save(cartelera);
        }
    
        //DELETE    
        public void deleteCartelera(Long id){
            boolean exists = carteleraRepository.existsById(id);
            if(!exists){
                throw new IllegalStateException("La cartelera con id " + id + " no esta disponible");
            }
            carteleraRepository.deleteById(id);
        }

  
}
