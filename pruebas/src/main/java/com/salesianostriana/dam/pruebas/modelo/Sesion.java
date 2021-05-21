package com.salesianostriana.dam.pruebas.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sesion {
	
	@Id
	@GeneratedValue
	private long sesion_id;

	private TipoSesion tipoSesion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="sesion")
	private List<Agrupacion> agrupaciones;
	
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
		this.agrupaciones.add(a);
		a.setSesion(this);
	}

	public void removeAgrupacion(Agrupacion a) {
		this.agrupaciones.remove(a);
		a.setSesion(null);
	}

}
