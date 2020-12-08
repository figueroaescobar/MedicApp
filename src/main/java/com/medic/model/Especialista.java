package com.medic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "especialista")
public class Especialista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_especialista;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "FK_especialista_especialidad"))
	private Especialidad especialidad;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "sexo", nullable = false, length = 10)
	private String sexo;
	
	@Column(name = "edad", nullable = false)
	private Integer edad;

	public Integer getId_especialista() {
		return id_especialista;
	}

	public void setId_especialista(Integer id_especialista) {
		this.id_especialista = id_especialista;
	}

	

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_especialista == null) ? 0 : id_especialista.hashCode());
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
		Especialista other = (Especialista) obj;
		if (id_especialista == null) {
			if (other.id_especialista != null)
				return false;
		} else if (!id_especialista.equals(other.id_especialista))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Especialista [id_especialista=" + id_especialista + ", id_especialidad=" + especialidad + ", nombre="
//				+ nombre + ", sexo=" + sexo + ", edad=" + edad + "]";
//	}
	
	

}
