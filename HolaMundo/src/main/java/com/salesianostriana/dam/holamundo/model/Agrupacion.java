package com.salesianostriana.dam.holamundo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agrupacion {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String director;
	private String procedencia;
	private String modalidad;
	private int puntos;
	
	public Agrupacion(String nombre, String director, String procedencia, String modalidad) {
		this.nombre = nombre;
		this.director = director;
		this.procedencia = procedencia;
		this.modalidad = modalidad;
		this.puntos= 0;
	}
}
