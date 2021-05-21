package com.salesianostriana.dam.pruebas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgrupacionSesion {

	@Id
	@GeneratedValue
	private long id;
	
	private long sesion_id;
	private long agrupacion_id;
	
	
}
