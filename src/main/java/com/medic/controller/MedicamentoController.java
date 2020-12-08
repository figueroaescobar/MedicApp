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
import com.medic.model.Medicamento;
import com.medic.service.IMedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	@Autowired
	private IMedicamentoService service;
	
	@GetMapping
	public ResponseEntity<List<Medicamento>> listar() {
		List<Medicamento> lista = service.listar();
		return new ResponseEntity<List<Medicamento>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> listarPorId(@PathVariable("id") Integer id) {
		Medicamento med = service.leerPorId(id);
		if (med.getId_medicamento() == null) {
			throw new ModeloNotFoundException("ID NO ENCNTRADO" + id);
		}
		return new ResponseEntity<Medicamento>(med, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Medicamento medicamento) {
		//Medicamento med = service.registrar(medicamento);
		//esp.getEspecialidad().getId_especialidad();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medicamento.getId_medicamento()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Medicamento> modificar(@Valid @RequestBody Medicamento medicamento) {
		Medicamento med = service.modificar(medicamento);
		return new ResponseEntity<Medicamento>(med, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Medicamento med = service.leerPorId(id);
		if (med.getId_medicamento() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
