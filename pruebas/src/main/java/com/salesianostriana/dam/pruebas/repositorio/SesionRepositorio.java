package com.salesianostriana.dam.pruebas.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebas.modelo.Sesion;

public interface SesionRepositorio extends JpaRepository<Sesion, Long>{

}
