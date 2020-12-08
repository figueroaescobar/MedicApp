package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.Medicamento;

public interface IMedicamentoRepo extends JpaRepository<Medicamento, Integer> {

}
