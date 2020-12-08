package com.medic.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.medic.model.Ficha;

public interface IFichaRepo extends JpaRepository<Ficha, Integer> {
	
	
}
