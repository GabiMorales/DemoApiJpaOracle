package com.demo2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo2.model.Persona;
import com.demo2.service.PersonaService;

@RestController
@RequestMapping("/api/persona/")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@PostMapping
	private ResponseEntity<Persona> guardar(@RequestBody Persona persona){
		Persona nuevaPersona = personaService.create(persona);
		try {
			return ResponseEntity.ok(nuevaPersona);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Persona>> listarTodo(){
		return ResponseEntity.ok(personaService.getAllPersonas());
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> eliminarPorId(@PathVariable("id") String id) {
		personaService.deletePorId(id);
		return ResponseEntity.ok(null);
	}
		
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Persona>> listarPorId(@PathVariable ("id") String id){
		return ResponseEntity.ok(personaService.findById(id));
	}
}
