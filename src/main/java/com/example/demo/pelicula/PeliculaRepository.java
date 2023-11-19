package com.example.demo.pelicula;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    Optional <Pelicula> findPeliculaById(Long id);        //return null;
    
}
