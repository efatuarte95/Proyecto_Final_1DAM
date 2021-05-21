package com.salesianostriana.dam.pruebas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.pruebas.modelo.AgrupacionSesion;

@Repository
public interface AgrupacionSesionRepositorio extends JpaRepository<AgrupacionSesion, Long>{

}
