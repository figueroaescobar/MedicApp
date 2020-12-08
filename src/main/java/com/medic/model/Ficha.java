package com.medic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ficha")
public class Ficha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_ficha;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_ficha_paciente"))
	private Paciente paciente;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_medicamento", nullable = false, foreignKey = @ForeignKey(name = "FK_ficha_medicamento"))
	private Medicamento medicamento;
	
	@Column(name = "dosis_medicamento", nullable = true, length = 100)
	private String dosis_medicamento;
	
	@Column(name = "frecuencia_medicamento", nullable = true, length = 100)
	private String frecuencia_medicamento;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "ficha", cascade = { CascadeType.ALL })
	private List<HistorialAtencion> histAtencion;
	
//	@ManyToOne
//	@JoinColumn(name = "id_histatencion", nullable = false, foreignKey = @ForeignKey(name = "FK_ficha_histatencion"))
//	private HistorialAtencion histAtencion;

	public List<HistorialAtencion> getHistAtencion() {
		return histAtencion;
	}

	public void setHistAtencion(List<HistorialAtencion> histAtencion) {
		this.histAtencion = histAtencion;
	}

	public Integer getId_ficha() {
		return id_ficha;
	}

	public void setId_ficha(Integer id_ficha) {
		this.id_ficha = id_ficha;
	}


	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public String getDosis_medicamento() {
		return dosis_medicamento;
	}

	public void setDosis_medicamento(String dosis_medicamento) {
		this.dosis_medicamento = dosis_medicamento;
	}

	public String getFrecuencia_medicamento() {
		return frecuencia_medicamento;
	}

	public void setFrecuencia_medicamento(String frecuencia_medicamento) {
		this.frecuencia_medicamento = frecuencia_medicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_ficha == null) ? 0 : id_ficha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ficha other = (Ficha) obj;
		if (id_ficha == null) {
			if (other.id_ficha != null)
				return false;
		} else if (!id_ficha.equals(other.id_ficha))
			return false;
		return true;
	}


	
	
	
}
