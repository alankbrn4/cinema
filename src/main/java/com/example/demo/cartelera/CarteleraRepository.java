package com.example.demo.cartelera;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface CarteleraRepository extends JpaRepository<Cartelera, Long>{
    Optional <Cartelera> findCarteleraById(Long id);        //return null;
}
