package com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio;

import org.springframework.stereotype.Service;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Sesion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.repositorio.AgrupacionRepositorio;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.repositorio.SesionRepositorio;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio.base.ServicioBase;

@Service
public class SesionServicio extends ServicioBase<Sesion, Long, SesionRepositorio>{

	private final AgrupacionRepositorio agrupacionRepositorio;
	
	public SesionServicio(SesionRepositorio repo, AgrupacionRepositorio agrupacionRepositorio) {
		super(repo);
		this.agrupacionRepositorio = agrupacionRepositorio;
	}

	public long numAgrupacionesSesion(long sesion_id) {
		return agrupacionRepositorio.countBySesion(sesion_id);
	}
}
