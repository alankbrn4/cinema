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
// Este tag es una clase de un controlador: los métodos dentro de ella manejarán las solicitudes HTTP y devolverán respuestas HTTP.
@RequestMapping(path = "api/asiento") // localhost:8080/api/asiento
// Especifica el mapeo de la URL base para todas las operaciones en este controlador.

public class AsientoCotroller {
    //Creamos una instancia de la clase usuarioService
    @Autowired
    //inyección de la dependencia AsientoService (almacena la lógica del negocio relacionada con los asientos)
    private final AsientoService asientoService;

    // Este constructor implementa la inyección de dependencias: AsientoController depende del servicio AsientoService.
    public AsientoCotroller(AsientoService asientoService) {
        this.asientoService = asientoService;
    }

    @GetMapping
    // Tag de solicitudes HTTP GET
    public List<Asiento> getAsiento(){
            //devuelve la lista de objetos "Asiento" 
        return asientoService.getAsiento();
    }

    @PostMapping
    // Tag de solicitudes HTTP POST
    public void registrarNuevoAsiento(@Validated @RequestBody Asiento asiento, BindingResult bindingResult){
        // Este método espera un objeto "Asiento" como cuerpo de la solicitud. El objeto asiento se debe deserializar a partir del cuerpo de la solicitud. 
        // La anotación @Validated indica que se deben aplicar las validaciones declaradas en la entidad Asiento.
        if (bindingResult.hasErrors()){
            throw new ApiRequestException("Asiento Registrado");
            // si la validación contiene errores se retorna el mensaje de error "Asiento Registrado"
        }
        asientoService.addNewAsiento(asiento);
        // si no hay errores en la validacion se llama al metodo addNewAsiento de la clase AsientoService y se añade un nuevo asiento
    }

    @DeleteMapping
    // Tag de solicitudes HTTP DELETE
    public void eliminarAsiento(Long id){
        // id: identificador único del asiento a eliminar
        
        asientoService.deleteAsiento(id);
        // se llama el métedo DELETE del servicio AsientoService y se elimina el id del asiento solicitado
    }


}
