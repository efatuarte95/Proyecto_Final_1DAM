package com.salesianostriana.dam.pruebas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agrupacion {
	
	@Id
	@GeneratedValue
	private long agrupacion_id;
	
	private String nombre;
	private String director;
	private String procedencia;
	private Modalidad modalidad;
	private String imagen;
	private int puntos;
	
	@ManyToOne
	private Sesion sesion;
	
	public Agrupacion(String nombre, String director, String procedencia, Modalidad modalidad, String imagen) {
		this.nombre = nombre;
		this.director = director;
		this.procedencia = procedencia;
		this.modalidad = modalidad;
		this.imagen = imagen;
		this.puntos = 0;
	}
	
	public Agrupacion(String nombre, String director, String procedencia, Modalidad modalidad, String imagen, Sesion sesion) {
		this.nombre = nombre;
		this.director = director;
		this.procedencia = procedencia;
		this.modalidad = modalidad;
		this.imagen = imagen;
		this.puntos = 0;
		this.sesion = sesion;
	}	

}
