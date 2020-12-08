package com.medic.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_paciente")
public class DetallePaciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetallePaciente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_detalle_paciente"))
	private Paciente paciente;
	
	@Column(name = "RUT", length = 9, nullable = false)
	private Integer rut;
	
	@Column(name = "DV", length = 1, nullable = false)
	private String dv;
	
	@Column(name = "REGION", length = 100, nullable = false)
	private String region;
	
	@Column(name = "CIUDAD", length = 100, nullable = false)
	private String ciudad;
	
	@Column(name = "COMUNA", length = 100, nullable = false)
	private String comuna;
	
	@Column(name = "EDAD", length = 9, nullable = false)
	private Integer edad;
	
	private LocalDateTime fechaNacimiento;
	
	@Column(name = "TELEFONO", length = 9, nullable = false)
	private Integer telefono;
	
	@Column(name = "ESTATURA", length = 10, nullable = false)
	private String estatura;
	
	@Column(name = "PESO", length = 10, nullable = false)
	private String peso;
	
	@Column(name = "NACIONALIDAD", length = 50, nullable = false)
	private String nacionalidad;
	
	@Column(name = "EMAIL", length = 100, nullable = false)
	private String email;
	
	@Column(name = "IMC", length = 100, nullable = false)
	private String imc;

	public Integer getIdDetallePaciente() {
		return idDetallePaciente;
	}

	public void setIdDetallePaciente(Integer idDetallePaciente) {
		this.idDetallePaciente = idDetallePaciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}
	
	
}
