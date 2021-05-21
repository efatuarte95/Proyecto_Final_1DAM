package com.salesianostriana.dam.pruebas.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.AgrupacionSesion;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.repositorio.AgrupacionRepositorio;
import com.salesianostriana.dam.pruebas.repositorio.AgrupacionSesionRepositorio;
import com.salesianostriana.dam.pruebas.repositorio.SesionRepositorio;
import com.salesianostriana.dam.pruebas.servicio.base.ServicioBase;

@Service
public class AgrupacionSesionServicio extends ServicioBase<AgrupacionSesion, Long, AgrupacionSesionRepositorio>{

	public AgrupacionSesionServicio(AgrupacionSesionRepositorio repo) {
		super(repo);
	}

	@Autowired
	private AgrupacionRepositorio agruRepositorio;
	
	@Autowired
	private SesionRepositorio sesionRepositorio;
	
	public void agregarAgrupacionSesion(long sesion, long agrupacion) {
		Optional<Agrupacion> a = agruRepositorio.findById(sesion);
		Optional<Sesion> s = sesionRepositorio.findById(agrupacion);
		sesionRepositorio.save(s.get().addAgrupacion(a.get()));
	}
}
