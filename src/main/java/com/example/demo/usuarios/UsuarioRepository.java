package com.example.demo.usuarios;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional <Usuario> findUsuarioById(Long id);        //return null;  
    @Query(""+ "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Student s WHERE s.email = ?1")
    boolean findUsuarioByEmail(String email);
}
