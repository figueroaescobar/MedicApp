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
@Table(name = "tipo_atencion")
public class TipoAtencion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipoatencion;
	
	@Column(name = "descripcion", nullable = false, length = 100)
	private String descripcion;

	public Integer getId_tipoatencion() {
		return id_tipoatencion;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoatencion", cascade = {CascadeType.ALL})
	private List<HistorialAtencion> histAtencion;

	public void setId_tipoatencion(Integer id_tipoatencion) {
		this.id_tipoatencion = id_tipoatencion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
