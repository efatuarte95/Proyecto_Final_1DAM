package com.salesianostriana.dam.holamundo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.holamundo.model.Agrupacion;
import com.salesianostriana.dam.holamundo.model.Sesion;
import com.salesianostriana.dam.holamundo.servicio.AgrupacionService;
import com.salesianostriana.dam.holamundo.servicio.SesionService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PseudoMain {
	
	private final SesionService sesionServicio;
	private final AgrupacionService agrupacionServicio;

	@PostConstruct
	public void initData() {
		
		List<Sesion> sesiones = List.of(
				new Sesion("Preliminares", 1, LocalDate.of(2021, Month.JANUARY, 20)),
				new Sesion("Preliminares", 2, LocalDate.of(2021, Month.JANUARY, 21)),
				new Sesion("Preliminares", 3, LocalDate.of(2021, Month.JANUARY, 22)),
				new Sesion("Preliminares", 4, LocalDate.of(2021, Month.JANUARY, 23))
		);
		
		List<Agrupacion> agrupaciones = List.of(
				new Agrupacion("La Chusma Selecta", "Antonio Martínez Ares", "Cádiz", "Comparsa"),
				new Agrupacion("Los Cadizfornia", "Jose Antonio Vera Luque", "Cádiz", "Chirigota"),
				new Agrupacion("La Colonial", "David Fernández", "Cádiz", "Coro"),
				new Agrupacion("El Cuarteto del More", "Iván Romero", "Cádiz", "Cuarteto"),
				new Agrupacion("Chernobyl, el musical", "'Canijo' de Sevilla", "Sevilla", "Chirigota"),
				new Agrupacion("Oh Capitán my Capitán", "Tino Tovar", "Cádiz", "Comparsa"),
				new Agrupacion("Equipo A minúscula", "El Morera", "Cádiz", "Cuarteto"),
				new Agrupacion("Los Superhombres", "Rafael Martin", "Sevilla", "Coro")
				);
		
		for (Sesion s : sesiones) {
			sesiones.add(s);
			sesionServicio.save(s);
		}
		
		for (Agrupacion a : agrupaciones) {
			agrupaciones.add(a);
			agrupacionServicio.save(a);
		}
		
	}
 	
}
