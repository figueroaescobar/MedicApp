package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.TipoAtencion;

public interface ITipoAtencionRepo extends JpaRepository<TipoAtencion, Integer> {

}
