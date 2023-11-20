package com.example.demo.asiento;

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
@RequestMapping(path = "api/asiento") // localhost:8080/api/asiento
public class AsientoCotroller {
    //Creamos una instancia de la clase usuarioService
    @Autowired
    private final AsientoService asientoService;

    //inyección de la dependencia usuarioService
    public AsientoCotroller(AsientoService asientoService) {
        this.asientoService = asientoService;
    }

    @GetMapping
    public List<Asiento> getAsiento(){
        
        return asientoService.getAsiento();
    }

    @PostMapping
    public void registrarNuevoAsiento(@Validated @RequestBody Asiento asiento, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Aseinot ya Registrado");
        }
        asientoService.addNewAsiento(asiento);
    }

    @DeleteMapping
    public void eliminarAsiento(Long id){
        
        asientoService.deleteAsiento(id);;
    }


}
