package com.medic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medic.model.Medicamento;
import com.medic.repo.IMedicamentoRepo;
import com.medic.service.IMedicamentoService;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {
	
	@Autowired
	private IMedicamentoRepo repo;
	
	@Override
	public Medicamento registrar(Medicamento med) {
		return repo.save(med);
	}
	
	@Override
	public Medicamento modificar(Medicamento med) {
		return repo.save(med);
	}
	
	@Override
	public List<Medicamento> listar() {
		return repo.findAll();
	}
	
	@Override
	public Medicamento leerPorId(Integer id) {
		Optional<Medicamento> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medicamento();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
