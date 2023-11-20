package com.example.demo.funcion;


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
@RequestMapping(path = "api/funcion") // localhost:8080/api/funcion
public class FuncionController {
    //Creamos una instancia de la clase funcionService
    @Autowired
    private final FuncionService funcionService;

    //inyección de la dependencia funcionService
    public FuncionController(FuncionService funcionService) {
        this.funcionService = funcionService;
    }

    @GetMapping
    public List<Funcion> getFunciones(){
        return funcionService.getFunciones();
    }

    @PostMapping
    public void registrarNuevaFuncion(@Validated @RequestBody Funcion funcion, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Funcion ya Completa");//Esto hay que modificarlo a una nueva excepción personalizada para cuando la funcion este llena
        }
        funcionService.addNewFuncion(funcion);
    }

    @DeleteMapping
    public void eliminarFuncion(Long id){
        
        funcionService.deleteFuncion(id);
    }
    
}
