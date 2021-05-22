package com.salesianostriana.dam.pruebas.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.repositorio.AgrupacionRepositorio;
import com.salesianostriana.dam.pruebas.servicio.base.ServicioBase;

/**
 * En esta clase definimos los métodos creados en el repositorio
 * @author Ernesto Fatuarte
 *
 */
@Service
public class AgrupacionServicio extends ServicioBase<Agrupacion, Long, AgrupacionRepositorio>{
	
	/**
	 * Constructor del servicio 
	 * @param repo
	 */
	public AgrupacionServicio(AgrupacionRepositorio repo) {
		super(repo);
	}
	
	/**
	 * Este metodo sirve para buscar una agrupación por su nombre
	 * @param nombre El nombre de la agrupacion a buscar
	 * @return Nos devuelve una agrupacion que coincide con el nombre pasado por parámetro
	 */
	public Agrupacion buscarPorNombre(String nombre) {
		return repositorio.findByNombre(nombre);
	}
	
	/**
	 * El siguiente método nos muestra las mejores 20 agrupaciones de una modalidad ordenadas por puntos
	 * @param modalidad La modalidad a consultar
	 * @return Una lista de agrupaciones ordenadas por puntos de la modalidad pasada por parámetro
	 */
	public List<Agrupacion> mostrarMejoresAgrupaciones(Modalidad modalidad) {
		return repositorio.findTop20ByModalidadOrderByPuntosDesc(modalidad);
	}
	
	/**
	 * El siguiente método nos muestra todas las agrupaciones de una modalidad
	 * @param modalidad La modalidad que queremos consultar
	 * @return Nos devuelve una lista de agrupaciones
	 */
	public List<Agrupacion> todasLasAgrupacionesDeUnaModalidad(Modalidad modalidad) {
		return repositorio.findByModalidadOrderByNombreAsc(modalidad);
	}
	
	/**
	 * El siguiente método nos muestra las agrupaciones cuyo nombre contenga el parámetro nombre
	 * @param nombre El contenido que pasaremos en el buscador
	 * @return Una lista de agrupaciones cuyo nombre contenga lo pasado por parámetro
	 */
	public List<Agrupacion> busquedaPorNombre(String nombre) {
		return repositorio.findByNombreContainsIgnoreCaseOrderByNombreAsc(nombre);
	}
	
	/**
	 * El siguiente método sirve para listar las agrupaciones de una sesión
	 * @param sesion La sesión que queremos ver
	 * @return Una lista de agrupaciones cuya sesión sea la indicada
	 */
	public List<Agrupacion> listarAgrupacionesSesion(Sesion sesion) {
		return repositorio.findBySesion(sesion);
	}
	
}
