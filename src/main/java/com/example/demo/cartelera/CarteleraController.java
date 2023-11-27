package com.example.demo.cartelera;


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
@RequestMapping(path = "api/cartelera") // localhost:8080/api/cartelera
public class CarteleraController {
    @Autowired
    private final CarteleraService carteleraService;

    //inyección de la dependencia carteleraService
    public CarteleraController(CarteleraService carteleraService) {
        this.carteleraService = carteleraService;
    }

    @GetMapping
    public List<Cartelera> getCarteleras(){
        return carteleraService.getCarteleras();
    }

    @PostMapping
    public void registrarNuevaCartelera(@Validated @RequestBody Cartelera cartelera, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Cartelera ya Completa");//Esto hay que modificarlo a una nueva excepción personalizada para cuando la cartelera este llena
        }
        carteleraService.addNewCartelera(cartelera);
    }

    @DeleteMapping
    public void eliminarCartelera(Long id){
        
        carteleraService.deleteCartelera(id);
    }
    
    
}
