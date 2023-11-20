package com.example.demo.funcion;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    Optional <Funcion> findFuncionById(Long id);        //return null;
}
