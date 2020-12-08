package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.HistorialAtencion;

public interface IHistorialAtencionRepo extends JpaRepository<HistorialAtencion, Integer> {

}
