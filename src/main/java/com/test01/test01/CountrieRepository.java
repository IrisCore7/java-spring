package com.test01.test01;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountrieRepository extends JpaRepository<Countrie, Integer>{
    
    // retorna una lista de countrie buscado por su id, y por las iniciales de algun nombre 
    List<Countrie> findByIdAndNameStartingWithIgnoreCase(Integer id, String name);

}