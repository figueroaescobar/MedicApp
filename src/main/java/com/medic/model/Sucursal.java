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
@Table(name = "sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_sucursal;
	
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public Integer getId_sucursal() {
		return id_sucursal;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "sucursal", cascade = { CascadeType.ALL })
	private List<HistorialAtencion> histAtencion;

	public List<HistorialAtencion> getHistAtencion() {
		return histAtencion;
	}

	public void setHistAtencion(List<HistorialAtencion> histAtencion) {
		this.histAtencion = histAtencion;
	}

	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
