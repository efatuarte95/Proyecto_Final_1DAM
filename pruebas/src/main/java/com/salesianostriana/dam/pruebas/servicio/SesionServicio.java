package com.salesianostriana.dam.pruebas.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.repositorio.SesionRepositorio;
import com.salesianostriana.dam.pruebas.servicio.base.ServicioBase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SesionServicio extends ServicioBase<Sesion, Long, SesionRepositorio>{

}
