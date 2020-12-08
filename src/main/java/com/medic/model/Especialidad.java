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
@Table(name = "especialidad")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_especialidad;
	
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public Integer getId_especialidad() {
		return id_especialidad;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "especialidad", cascade = { CascadeType.ALL })
	private List<Especialista> especialista;

	public List<Especialista> getEspecialista() {
		return especialista;
	}

	public void setEspecialista(List<Especialista> especialista) {
		this.especialista = especialista;
	}

	public void setId_especialidad(Integer id_especialidad) {
		this.id_especialidad = id_especialidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
