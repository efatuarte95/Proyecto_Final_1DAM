package com.salesianostriana.dam.pruebas.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sesion {
	
	@Id
	@GeneratedValue
	private long sesion_id;

	private TipoSesion tipoSesion;
	private LocalDate fecha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name = "sesion_id"), 
			inverseJoinColumns = @JoinColumn(name = "agrupacion_id")
	)
	private List<Agrupacion> agrupaciones = new ArrayList<>();
	
	public Sesion(TipoSesion tipoSesion, LocalDate fecha) {
		this.tipoSesion = tipoSesion;
		this.fecha = fecha;
	}
	
	public Sesion(TipoSesion tipoSesion, LocalDate fecha, List<Agrupacion> agrupaciones) {
		this.tipoSesion = tipoSesion;
		this.fecha = fecha;
		this.agrupaciones = agrupaciones;
	}

	/** MÉTODOS HELPERS **/

	public void addAgrupacion(Agrupacion a) {
		agrupaciones.add(a);
		a.getSesiones().add(this);
	}

	public void removeAgrupacion(Agrupacion a) {
		agrupaciones.remove(a);
		a.getSesiones().remove(this);
	}

}
