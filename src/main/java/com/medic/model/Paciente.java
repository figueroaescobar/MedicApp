package com.medic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;
	
	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "APELLIDO", nullable = false, length = 100)
	private String apellido;
	
	@Column(name = "DIRECCION", nullable = false, length = 100)
	private String direccion;
	
	@OneToMany(mappedBy = "paciente", cascade = { CascadeType.ALL}, orphanRemoval = true)
	private List<DetallePaciente> detallePaciente;
	
	@OneToOne(mappedBy = "paciente", cascade = { CascadeType.ALL}, orphanRemoval = true)
	private Ficha ficha;
	
	

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<DetallePaciente> getDetallePaciente() {
		return detallePaciente;
	}

	public void setDetallePaciente(List<DetallePaciente> detallePaciente) {
		this.detallePaciente = detallePaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPaciente == null) ? 0 : idPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (idPaciente == null) {
			if (other.idPaciente != null)
				return false;
		} else if (!idPaciente.equals(other.idPaciente))
			return false;
		return true;
	}
	
	
}
