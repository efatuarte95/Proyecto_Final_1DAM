package com.salesianostriana.dam.pruebas;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Principal {

	private final AgrupacionServicio agrupacionServicio;
	private final SesionServicio sesionServicio;

	@PostConstruct
	public void initData() {
		List<Sesion> sesiones = List.of(
				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 20)),
				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 21)),
				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 22)),
				new Sesion("Preliminares", LocalDate.of(2021, Month.JANUARY, 23))
		);
		
		List<Agrupacion> agrupaciones = List.of(
				new Agrupacion("La Chusma Selecta", "Antonio Martínez Ares", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Cadizfornia", "Jose Antonio Vera Luque", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La Colonial", "David Fernández", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("El Cuarteto del More", "Iván Romero", "Cádiz", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Chernobyl, el musical", "'Canijo' de Sevilla", "Sevilla", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Oh Capitán my Capitán", "Tino Tovar", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Equipo A minúscula", "El Morera", "Cádiz", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Superhombres", "Rafael Martin", "Sevilla", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp")
				);
		
		for (Sesion s : sesiones) {
			sesionServicio.save(s);
		}
		
		for (Agrupacion a : agrupaciones) {
			agrupacionServicio.save(a);
		}
		
	}
}
