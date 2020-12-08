package com.medic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.Especialista;
import com.medic.repo.IEspecialistaRepo;
import com.medic.service.IEspecialistaService;

@Service
public class EspecialistaServiceImpl implements IEspecialistaService {

	@Autowired
	private IEspecialistaRepo repo;
	
	@Override
	public Especialista registrar(Especialista esp) {
		return repo.save(esp);
	}
	
	@Override
	public Especialista modificar(Especialista esp) {
		return repo.save(esp);
	}
	
	@Override
	public List<Especialista> listar() {
		return repo.findAll();
	}
	
	@Override
	public Especialista leerPorId(Integer id) {
		Optional<Especialista> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Especialista();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
