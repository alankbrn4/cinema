package com.example.demo.sala;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
    Optional <Sala> findSalaById(Long id);        //return null;
    
}
