package com.salesianostriana.dam.pruebas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Sesion;

public interface AgrupacionRepositorio extends JpaRepository<Agrupacion, Long> {
	
	public Agrupacion findByNombre(String nombre);	
	public List<Agrupacion> findTop10ByModalidadOrderByPuntosDesc(String modalidad);
	public List<Agrupacion> findByModalidad(String modalidad);
	public long countBySesiones(Sesion sesion); 

}
