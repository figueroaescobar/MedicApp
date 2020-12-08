package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.Especialista;

public interface IEspecialistaRepo extends JpaRepository<Especialista, Integer> {

}
