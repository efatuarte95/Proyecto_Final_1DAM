package com.salesianostriana.dam.holamundo.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sesion {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private int orden;
	private LocalDate fecha;
	
	public Sesion(String nombre, int orden, LocalDate fecha) {
		this.nombre = nombre;
		this.orden = orden;
		this.fecha = fecha;
	}
	
}
