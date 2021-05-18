package com.salesianostriana.dam.pruebas.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy="agrupaciones", fetch = FetchType.EAGER)
	private List<Sesion> sesiones = new ArrayList<>();
	
	public Agrupacion(String nombre, String director, String procedencia, Modalidad modalidad, String imagen) {
		this.nombre = nombre;
		this.director = director;
		this.procedencia = procedencia;
		this.modalidad = modalidad;
		this.imagen = imagen;
		this.puntos = 0;
	}
	
	public Agrupacion(String nombre, String director, String procedencia, Modalidad modalidad, String imagen, List<Sesion> sesiones) {
		this.nombre = nombre;
		this.director = director;
		this.procedencia = procedencia;
		this.modalidad = modalidad;
		this.imagen = imagen;
		this.puntos = 0;
		this.sesiones = sesiones;
	}	
	
	/** MÉTODOS HELPERS **/

	public void addSesion(Sesion s) {
		sesiones.add(s);
		s.getAgrupaciones().add(this);
	}

	public void removeSesion(Sesion s) {
		sesiones.remove(s);
		s.getAgrupaciones().remove(this);
	}

}
