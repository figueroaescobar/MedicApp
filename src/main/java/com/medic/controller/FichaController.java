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
import com.medic.model.Ficha;
import com.medic.service.IFichaService;


@RestController
@RequestMapping("/ficha")
public class FichaController {
	
	@Autowired
	private IFichaService service;
	
	
	@GetMapping("'{id}'")
	public ResponseEntity<List<Ficha>> listar() {
		List<Ficha> lista = service.listar();
		return new ResponseEntity<List<Ficha>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ficha> listarPorId(@PathVariable("id") Integer id) {
		Ficha ficha = service.leerPorId(id);
		if (ficha.getId_ficha() == null) {
			throw new ModeloNotFoundException("ID NO ENCNTRADO" + id);
		}
		return new ResponseEntity<Ficha>(ficha, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Ficha ficha) {
		//Ficha f = service.registrar(ficha);
		//esp.getEspecialidad().getId_especialidad();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ficha.getId_ficha()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Ficha> modificar(@Valid @RequestBody Ficha ficha) {
		Ficha f = service.modificar(ficha);
		return new ResponseEntity<Ficha>(f, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Ficha ficha = service.leerPorId(id);
		if (ficha.getId_ficha() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
