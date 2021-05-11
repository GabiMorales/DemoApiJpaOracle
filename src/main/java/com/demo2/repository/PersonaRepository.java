package com.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo2.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {

}
