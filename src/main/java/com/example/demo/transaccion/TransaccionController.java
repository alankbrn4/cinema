package com.example.demo.transaccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.sala.Sala;
import com.example.demo.sala.SalaService;
import com.example.demo.usuarios.Usuario;
import com.example.demo.usuarios.UsuarioService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@RestController
@RequestMapping(path = "api/transaccion") // localhost:8080/api/transaccion
public class TransaccionController {
    //Creamos una instancia de la clase usuarioService
    @Autowired
    private final TransaccionService transaccionService;

    //inyección de la dependencia usuarioService
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public List<Transaccion> getTransaccion(){
        
        return transaccionService.getTransaccion();
    }

    @PostMapping
    public void registrarNuevaTransaccion(@Validated @RequestBody Transaccion transaccion, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Transaccion no reconocida");//Esto hay que modificarlo a una nueva excepción personalizada para cuando la sala este llena
        }
        transaccionService.addNewTransaccion(transaccion);
    }

    @DeleteMapping
    public void eliminarTransaccion(Long id){
        
        transaccionService.deleteTransaccion(id);
    }
    
}
