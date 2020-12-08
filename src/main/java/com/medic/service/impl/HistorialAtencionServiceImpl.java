package com.medic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.HistorialAtencion;
import com.medic.repo.IHistorialAtencionRepo;
import com.medic.service.IHistorialAtencionService;

@Service
public class HistorialAtencionServiceImpl implements IHistorialAtencionService {
	
	@Autowired
	private IHistorialAtencionRepo repo;
	
	@Override
	public HistorialAtencion registrar(HistorialAtencion ha) {
		return repo.save(ha);
	}
	
	@Override
	public HistorialAtencion modificar(HistorialAtencion ha) {
		return repo.save(ha);
	}
	
	@Override
	public List<HistorialAtencion> listar() {
		return repo.findAll();
	}
	
	@Override
	public HistorialAtencion leerPorId(Integer id) {
		Optional<HistorialAtencion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new HistorialAtencion();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
