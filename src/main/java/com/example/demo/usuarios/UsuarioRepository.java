package com.example.demo.usuarios;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional <Usuario> findUsuarioById(Long id); 
    Optional <Usuario> findUsuarioByEmail(String email); 
    //return null;
    
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM Usuario u WHERE u.email = ?1")
    
    boolean existUsuarioByEmail(String email2);
}

