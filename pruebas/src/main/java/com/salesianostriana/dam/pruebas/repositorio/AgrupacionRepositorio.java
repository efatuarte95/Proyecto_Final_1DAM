package com.salesianostriana.dam.pruebas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;

public interface AgrupacionRepositorio extends JpaRepository<Agrupacion, Long> {
	
	Agrupacion findByNombre(String nombre);	
	List<Agrupacion> findTop10ByModalidadOrderByPuntosDesc(String modalidad);
	
}
