package com.medic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.Especialidad;
import com.medic.repo.IEspecialidadRepo;
import com.medic.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {
	
	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	public Especialidad registrar(Especialidad esp) {
		return repo.save(esp);
	}
	
	@Override
	public Especialidad modificar(Especialidad esp) {
		return repo.save(esp);
	}
	
	@Override
	public List<Especialidad> listar() {
		return repo.findAll();
	}
	
	@Override
	public Especialidad leerPorId(Integer id) {
		Optional<Especialidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Especialidad();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
