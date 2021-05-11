package com.demo2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo2.model.Persona;
import com.demo2.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public Persona create (Persona persona) {
		return personaRepository.save(persona);
	}
	
	public List<Persona> getAllPersonas(){
		return personaRepository.findAll();
	}
		
	public Optional<Persona> findById (String id) {
		return personaRepository.findById(id);
	}
	
	public void deletePorId(String id) {
		personaRepository.deleteById(id);
	}
}
