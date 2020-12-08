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
import com.medic.model.Sucursal;
import com.medic.service.ISucursalService;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	private ISucursalService service;
	
	@GetMapping("'{id}'")
	public ResponseEntity<List<Sucursal>> listar() {
		List<Sucursal> lista = service.listar();
		return new ResponseEntity<List<Sucursal>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sucursal> listarPorId(@PathVariable("id") Integer id) {
		Sucursal suc = service.leerPorId(id);
		if(suc.getId_sucursal() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}		
		return new ResponseEntity<Sucursal>(suc, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Sucursal sucursal) {
//		Sucursal suc = service.registrar(sucursal);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sucursal.getId_sucursal()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Sucursal> modificar(@Valid @RequestBody Sucursal sucursal) {
		Sucursal suc = service.modificar(sucursal);
		return new ResponseEntity<Sucursal>(suc, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Sucursal suc = service.leerPorId(id);
		if(suc.getId_sucursal() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
