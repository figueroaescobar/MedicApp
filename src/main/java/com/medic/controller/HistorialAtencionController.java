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
import com.medic.model.HistorialAtencion;
import com.medic.service.IHistorialAtencionService;

@RestController
@RequestMapping("/histAtencion")
public class HistorialAtencionController {

	/*
	@Autowired
	private IHistorialAtencionService service;
	
	@GetMapping("'{id}'")
	public ResponseEntity<List<HistorialAtencion>> listar() {
		List<HistorialAtencion> lista = service.listar();
		return new ResponseEntity<List<HistorialAtencion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HistorialAtencion> listarPorId(@PathVariable("id") Integer id) {
		HistorialAtencion hist = service.leerPorId(id);
		if (hist.getId_histatencion() == null) {
			throw new ModeloNotFoundException("ID NO ENCNTRADO" + id);
		}
		return new ResponseEntity<HistorialAtencion>(hist, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody HistorialAtencion histatencion) {
		HistorialAtencion hist = service.registrar(histatencion);
		//esp.getEspecialidad().getId_especialidad();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(histatencion.getId_histatencion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<HistorialAtencion> modificar(@Valid @RequestBody HistorialAtencion histatencion) {
		HistorialAtencion hist = service.modificar(histatencion);
		return new ResponseEntity<HistorialAtencion>(hist, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		HistorialAtencion hist = service.leerPorId(id);
		if (hist.getId_histatencion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	*/
}
