package com.medic.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medic.exception.ModeloNotFoundException;
import com.medic.model.Especialista;
import com.medic.service.IEspecialistaService;

@RestController
@RequestMapping("/especialista")
public class EspecialistaController {
	
	@Autowired
	private IEspecialistaService service;
	
	@GetMapping("'{id}'")
	public ResponseEntity<List<Especialista>> listar() {
		List<Especialista> lista = service.listar();
		return new ResponseEntity<List<Especialista>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialista> listarPorId(@PathVariable("id") Integer id) {
		Especialista esp = service.leerPorId(id);
		if (esp.getId_especialista() == null) {
			throw new ModeloNotFoundException("ID NO ENCNTRADO" + id);
		}
		return new ResponseEntity<Especialista>(esp, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Especialista especialista) {
		//Especialista esp = service.registrar(especialista);
		//esp.getEspecialidad().getId_especialidad();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(especialista.getId_especialista()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Especialista> modificar(@Valid @RequestBody Especialista especialista) {
		Especialista esp = service.modificar(especialista);
		return new ResponseEntity<Especialista>(esp, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Especialista esp = service.leerPorId(id);
		if (esp.getId_especialista() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
