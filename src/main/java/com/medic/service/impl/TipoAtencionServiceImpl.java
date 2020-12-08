package com.medic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.TipoAtencion;
import com.medic.repo.ITipoAtencionRepo;
import com.medic.service.ITipoAtencionService;

@Service
public class TipoAtencionServiceImpl implements ITipoAtencionService {
	
	@Autowired
	private ITipoAtencionRepo repo;
	
	@Override
	public TipoAtencion registrar(TipoAtencion tipoatencion) {
		return repo.save(tipoatencion);
	}
	
	@Override
	public TipoAtencion modificar(TipoAtencion tipoatencion) {
		return repo.save(tipoatencion);
	}
	
	@Override
	public List<TipoAtencion> listar() {
		return repo.findAll();
	}
	
	@Override
	public TipoAtencion leerPorId(Integer id) {
		Optional<TipoAtencion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new TipoAtencion();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
