package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.Especialidad;

public interface IEspecialidadRepo extends JpaRepository<Especialidad, Integer> {

}
