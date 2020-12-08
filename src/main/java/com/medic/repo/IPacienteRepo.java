package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
