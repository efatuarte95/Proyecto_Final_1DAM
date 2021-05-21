package com.salesianostriana.dam.pruebas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;

public interface AgrupacionRepositorio extends JpaRepository<Agrupacion, Long> {
	
	public Agrupacion findByNombre(String nombre);	
	public List<Agrupacion> findTop20ByModalidadOrderByPuntosDesc(Modalidad modalidad);
	public List<Agrupacion> findByModalidadOrderByNombreAsc(Modalidad modalidad);
	public List<Agrupacion> findByNombreContainsOrderByNombreAsc(String consulta);
	public long countBySesion(long sesion_id);
	public List<Agrupacion> findBySesion(Sesion sesion);
}
