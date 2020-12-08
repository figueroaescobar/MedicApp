package com.medic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medicamento")
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_medicamento;
	
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "medicamento", cascade = { CascadeType.ALL })
	private List<Ficha> ficha;

	public List<Ficha> getFicha() {
		return ficha;
	}

	public void setFicha(List<Ficha> ficha) {
		this.ficha = ficha;
	}

	public Integer getId_medicamento() {
		return id_medicamento;
	}

	public void setId_medicamento(Integer id_medicamento) {
		this.id_medicamento = id_medicamento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
