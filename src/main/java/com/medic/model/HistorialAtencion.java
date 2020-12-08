package com.medic.model;

import java.time.LocalDateTime;

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
@Table(name = "historial_atencion")
public class HistorialAtencion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_histatencion;
	
	@ManyToOne
	@JoinColumn(name = "id_tipoatencion", nullable = false, foreignKey = @ForeignKey(name = "FK_histatencion_tipo"))
	private TipoAtencion tipoatencion;
	
	@ManyToOne
	@JoinColumn(name = "id_especialista", nullable = false, foreignKey = @ForeignKey(name = "FK_histatencion_especialista"))
	private Especialista especialista;
	
	@ManyToOne
	@JoinColumn(name = "id_sucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_histatencion_sucursal"))
	private Sucursal sucursal;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_ficha",nullable = false, foreignKey = @ForeignKey(name = "FK_histatencion_ficha"))
	private Ficha ficha;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "histAtencion", cascade = {CascadeType.ALL})
//	private List<Ficha> ficha;
	
	
	
//	public List<Ficha> getFicha() {
//		return ficha;
//	}
//
//	public void setFicha(List<Ficha> ficha) {
//		this.ficha = ficha;
//	}

	private LocalDateTime fecha_hora_atencion;

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Integer getId_histatencion() {
		return id_histatencion;
	}

	public void setId_histatencion(Integer id_histatencion) {
		this.id_histatencion = id_histatencion;
	}

	public TipoAtencion getTipoatencion() {
		return tipoatencion;
	}

	public void setTipoatencion(TipoAtencion tipoatencion) {
		this.tipoatencion = tipoatencion;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public LocalDateTime getFecha_hora_atencion() {
		return fecha_hora_atencion;
	}

	public void setFecha_hora_atencion(LocalDateTime fecha_hora_atencion) {
		this.fecha_hora_atencion = fecha_hora_atencion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_histatencion == null) ? 0 : id_histatencion.hashCode());
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
		HistorialAtencion other = (HistorialAtencion) obj;
		if (id_histatencion == null) {
			if (other.id_histatencion != null)
				return false;
		} else if (!id_histatencion.equals(other.id_histatencion))
			return false;
		return true;
	}
}
