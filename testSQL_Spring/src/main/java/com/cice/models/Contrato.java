package com.cice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Contrato {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Integer duracion;
	
	@Column
	private Long salario;
	
	@ManyToOne
	private Entrenador entrenador;

	public Contrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Contrato(Long id, Integer duracion, Long salario, Entrenador entrenador) {
		super();
		this.id = id;
		this.duracion = duracion;
		this.salario = salario;
		this.entrenador = entrenador;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
}
