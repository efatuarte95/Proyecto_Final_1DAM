package com.salesianostriana.dam.pruebas;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Principal {

//	private final AgrupacionServicio agrupacionServicio;
//	private final SesionServicio sesionServicio;

//	@PostConstruct
//	public void initData() {
//		List<Sesion> sesiones = List.of(
//				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 20)),
//				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 21)),
//				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 22)),
//				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 23))
//		);
//		
//		List<Agrupacion> agrupaciones = List.of(
//				new Agrupacion("La Chusma Selecta", "Antonio Martínez Ares", "Cádiz", "Comparsa"),
//				new Agrupacion("Los Cadizfornia", "Jose Antonio Vera Luque", "Cádiz", "Chirigota"),
//				new Agrupacion("La Colonial", "David Fernández", "Cádiz", "Coro"),
//				new Agrupacion("El Cuarteto del More", "Iván Romero", "Cádiz", "Cuarteto"),
//				new Agrupacion("Chernobyl, el musical", "'Canijo' de Sevilla", "Sevilla", "Chirigota"),
//				new Agrupacion("Oh Capitán my Capitán", "Tino Tovar", "Cádiz", "Comparsa"),
//				new Agrupacion("Equipo A minúscula", "El Morera", "Cádiz", "Cuarteto"),
//				new Agrupacion("Los Superhombres", "Rafael Martin", "Sevilla", "Coro")
//				);
//		
//		for (Sesion s : sesiones) {
//			sesiones.add(s);
//			sesionServicio.save(s);
//		}
//		
//		for (Agrupacion a : agrupaciones) {
//			agrupaciones.add(a);
//			agrupacionServicio.save(a);
//		}
//		
//	}
}
