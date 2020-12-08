package com.medic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.Sucursal;

public interface ISucursalRepo extends JpaRepository<Sucursal, Integer> {

}
