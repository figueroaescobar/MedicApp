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
import com.medic.model.TipoAtencion;
import com.medic.service.ITipoAtencionService;

@RestController
@RequestMapping("/tipoAtencion")
public class TipoAtencionController {

	@Autowired
	private ITipoAtencionService service;
	
	@GetMapping("'{id}'")
	public ResponseEntity<List<TipoAtencion>> listar() {
		List<TipoAtencion> lista = service.listar();
		return new ResponseEntity<List<TipoAtencion>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoAtencion> listarPorId(@PathVariable("id") Integer id) {
		TipoAtencion tipo = service.leerPorId(id);
		if (tipo.getId_tipoatencion() == null) {
			throw new ModeloNotFoundException("ID NO ENCNTRADO" + id);
		}
		return new ResponseEntity<TipoAtencion>(tipo, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody TipoAtencion tipoatencion) {
//		TipoAtencion tipo = service.registrar(tipoatencion);
		//esp.getEspecialidad().getId_especialidad();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoatencion.getId_tipoatencion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<TipoAtencion> modificar(@Valid @RequestBody TipoAtencion tipoatencion) {
		TipoAtencion tipo = service.modificar(tipoatencion);
		return new ResponseEntity<TipoAtencion>(tipo, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		TipoAtencion tipo = service.leerPorId(id);
		if (tipo.getId_tipoatencion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
