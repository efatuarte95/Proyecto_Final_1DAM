package com.salesianostriana.dam.pruebas.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.repositorio.AgrupacionRepositorio;
import com.salesianostriana.dam.pruebas.servicio.base.ServicioBase;


@Service
public class AgrupacionServicio extends ServicioBase<Agrupacion, Long, AgrupacionRepositorio>{
	
	public AgrupacionServicio(AgrupacionRepositorio repo) {
		super(repo);
	}
	
	public Agrupacion buscarPorNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}
	
	public List<Agrupacion> mostrarMejoresAgrupaciones(Modalidad modalidad) {
		return repositorio.findTop20ByModalidadOrderByPuntosDesc(modalidad);
	}
	
	public List<Agrupacion> mostrarAgrupacionesModalidad(Modalidad modalidad) {
		return repositorio.findByModalidad(modalidad);
	}
	
}
