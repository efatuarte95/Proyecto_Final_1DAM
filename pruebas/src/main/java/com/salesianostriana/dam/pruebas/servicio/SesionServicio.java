package com.salesianostriana.dam.pruebas.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.repositorio.AgrupacionRepositorio;
import com.salesianostriana.dam.pruebas.repositorio.SesionRepositorio;
import com.salesianostriana.dam.pruebas.servicio.base.ServicioBase;

@Service
public class SesionServicio extends ServicioBase<Sesion, Long, SesionRepositorio>{

	private final AgrupacionRepositorio agrupacionRepositorio;
	
	public SesionServicio(SesionRepositorio repo, AgrupacionRepositorio agrupacionRepositorio) {
		super(repo);
		this.agrupacionRepositorio = agrupacionRepositorio;
	}

	public long numAgrupacionesSesion(Sesion sesion) {
		return agrupacionRepositorio.countBySesiones(sesion);
	}
	
	public void agregarAgrupacionSesion(long sesion, long agrupacion) {
		Optional<Agrupacion> a = agrupacionRepositorio.findById(sesion);
		Optional<Sesion> s = repositorio.findById(agrupacion);
		repositorio.save(s.get().addAgrupacion(a.get()));
	}
}
