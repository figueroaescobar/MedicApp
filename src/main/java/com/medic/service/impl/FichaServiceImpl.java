package com.medic.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.Ficha;
import com.medic.repo.IFichaRepo;
import com.medic.service.IFichaService;

@Service
public class FichaServiceImpl implements IFichaService {

	@Autowired
	private IFichaRepo repo;
	
//	@Autowired
//	private IPacienteService service;
	
	@Override
	public Ficha registrar(Ficha ficha) {
		ficha.getHistAtencion().forEach(det -> {
			det.setFicha(ficha);
		});
		return repo.save(ficha);
	}
	
	@Override
	public Ficha modificar(Ficha ficha) {
		return repo.save(ficha);
	}
	
	@Override
	public List<Ficha> listar() {
		return repo.findAll();
	}
	
	@Override
	public Ficha leerPorId(Integer id) {
		Optional<Ficha> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Ficha();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
