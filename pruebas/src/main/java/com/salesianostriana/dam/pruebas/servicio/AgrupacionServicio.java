package com.salesianostriana.dam.pruebas.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.repositorio.AgrupacionRepositorio;
import com.salesianostriana.dam.pruebas.servicio.base.ServicioBase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgrupacionServicio extends ServicioBase<Agrupacion, Long, AgrupacionRepositorio>{

	public Agrupacion buscarPorNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}
	
	public List<Agrupacion> mostrarMejoresAgrupaciones(String modalidad) {
		return repositorio.findTop10ByModalidadOrderByPuntosDesc(modalidad);
	}
	
}
