package com.salesianostriana.dam.proyectofinal1damernestofatuarte.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Agrupacion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Modalidad;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Sesion;

/**
 * En esta clase crearemos las consultas relacionadas con las agrupaciones
 * @author Ernesto Fatuarte
 *
 */
public interface AgrupacionRepositorio extends JpaRepository<Agrupacion, Long> {
	
	// Metodo para buscar por nombre
	public Agrupacion findByNombre(String nombre);	
	
	// Metodo para mostrar las mejores 20 agrupaciones ordenadas por puntos
	public List<Agrupacion> findTop20ByModalidadOrderByPuntosDesc(Modalidad modalidad);
	
	// Metodo para listar las agrupaciones de una modalidad ordenadas por el nombre
	public List<Agrupacion> findByModalidadOrderByNombreAsc(Modalidad modalidad);
	
	// Metodo para encontrar una agrupación segun el nombre pasado por el buscador
	public List<Agrupacion> findByNombreContainsIgnoreCaseOrderByNombreAsc(String consulta);
	
	// Metodo para contar las agrupaciones que existen en una sesión
	public long countBySesion(long sesion_id);
	
	// Metodo para buscar las agrupaciones pertenecientes a una sesión
	public List<Agrupacion> findBySesion(Sesion sesion);
}
