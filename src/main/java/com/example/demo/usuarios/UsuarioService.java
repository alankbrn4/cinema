package com.example.demo.usuarios;

//Componentes de Spring
import org.springframework.stereotype.Component;

import com.example.demo.exception.ApiRequestException;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Component
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //GET
    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    //POST  
    public void addNewUsuario(Usuario usuario){

        Boolean usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail()); //Bussiness Logic

        if (validateEmail(usuario.getEmail()) == false) {
            throw new ApiRequestException("correo invalido");
        }
        else if (usuarioByEmail) {
            throw new IllegalStateException("email taken");
        }

        usuarioRepository.save(usuario);
    }

    //DELETE
    public void deleteUsuario(Long id){
        boolean exists = usuarioRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("El usuario con id " + id + " no existe");
        }
        usuarioRepository.deleteById(id);
    }

    //Validar correo
    public boolean validateEmail(String email) {
        String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
