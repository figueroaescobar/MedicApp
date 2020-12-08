package com.medic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.Sucursal;
import com.medic.repo.ISucursalRepo;
import com.medic.service.ISucursalService;

@Service
public class SucursalServiceImpl implements ISucursalService {

	@Autowired
	private ISucursalRepo repo;
	
	@Override
	public Sucursal registrar(Sucursal suc) {
		return repo.save(suc);
	}
	
	@Override
	public Sucursal modificar(Sucursal suc) {
		return repo.save(suc);
	}
	
	@Override
	public List<Sucursal> listar() {
		return repo.findAll();
	}
	
	@Override
	public Sucursal leerPorId(Integer id) {
		Optional<Sucursal> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Sucursal();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
