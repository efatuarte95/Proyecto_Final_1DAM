package com.salesianostriana.dam.pruebas;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.modelo.TipoSesion;
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
				new Sesion(TipoSesion.Preliminares, LocalDate.of(2021, Month.JANUARY, 20)),
				new Sesion(TipoSesion.Preliminares, LocalDate.of(2021, Month.JANUARY, 21)),
				new Sesion(TipoSesion.Preliminares, LocalDate.of(2021, Month.JANUARY, 22)),
				new Sesion(TipoSesion.Preliminares, LocalDate.of(2021, Month.JANUARY, 23)),
				new Sesion(TipoSesion.Preliminares, LocalDate.of(2021, Month.JANUARY, 24)),
				new Sesion(TipoSesion.Preliminares, LocalDate.of(2021, Month.JANUARY, 25)),
				new Sesion(TipoSesion.Cuartos, LocalDate.of(2021, Month.JANUARY, 30)),
				new Sesion(TipoSesion.Cuartos, LocalDate.of(2021, Month.FEBRUARY, 01)),
				new Sesion(TipoSesion.Cuartos, LocalDate.of(2021, Month.FEBRUARY, 02))
		);
		
		List<Agrupacion> agrupaciones = List.of(
			// Creamos comparsas de ejemplo
				new Agrupacion("La Chusma Selecta", "Martínez Ares", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("¡Oh capitán, my capitán!", "Tino Tovar", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La Canción de la Laguna", "David Carapapa", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Listos", "Chapa y Aranda", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Encaidenaos", "Kike Remolino", "Sevilla", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Tocaos del Ala", "El Lacio", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La Ciudad de Dios", "Jesús Pérez Fuentes", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Pacientes", "Fran Quintana", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Majaras", "Nono Galán", "Conil", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La tierra de la alegría", "Jesús Monje", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Resilientes", "Germán Rendón", "Algeciras", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Aislados", "Jonathan Pérez", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("El Arenero", "David Campano López", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Últimos Poetas", "Lolo Barragán", "Huelva", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("El gran dictador", "Juanma Hernández", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Hospital Febrero", "José María Fernández Garrido", "Córdoba", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Traicioneros", "Jose Javier Puerto", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La Superviviente", "Darío Falcón", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Primerizzos", "David Príncipe", "Sevilla", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Sólo sé que no sé nada", "Borja Romero", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				
			// Creamos chirigotas de ejemplo
				new Agrupacion("Los Cadizfornia", "Vera Luque", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Estrés por Cuatro", "El Selu", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los niños de la Petróleo", "Sheriff", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Gipsy Scream", "Jesús Benárquez", "Sevilla", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Chernobyl, el musical", "El Canijo de Carmona", "Sevilla", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Pídeme lo que tu quieras", "Los Molina", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Dio Picha!", "Juan Carlos Aragón", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Couchers LowCost", "El Bizcocho", "San José de la Rinconada", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Aquí estamos de paso", "Cascana", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Geni de Cádiz", "Jose Miguel Choza", "Isla Cristina", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("No aguantamos más, vamos de impacientes", "Fermín Coto", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los hijos del Carota", "Jose Manuel Martínez", "Conil", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Viejos del Parque", "Juan Francisco Castro", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Las Yeni Walker", "Jose Manuel Ramírez", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("No te gusta ná José", "Jose Miguel Choza", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("¿Qué disse Cabessa?", "Roberto Leal", "Sevilla", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Las Eventuales", "Luis Rossi", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los 7 locos", "David Amaya", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Joaquin Dead", "Jose María Parrado", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los de la Resistencia", "Cárdenas y Peñalver", "Los Palacios", Modalidad.Chirigota, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				
			// Creamos cuartetos de ejemplo
				new Agrupacion("Aquí no hace frío, aquí hace humedad", "David Reyes", "Cádiz", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Vida y Obra de JC1, Bajo D", "El Gago", "Cádiz", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Cari, resiste", "Javi Aguilera", "Sevilla", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("El cuarteto del More", "Iván Romero", "Cádiz", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Merda Merda, mucha Merda", "Nueva Agrupación", "Huelva", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Brigada Amarilla, Agüita con nojotro", "El Morera", "Cádiz", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Vaya papa traemos", "Nueva Agrupación", "Conil", Modalidad.Cuarteto, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),

			// Creamos coros de ejemplo
				new Agrupacion("Tócame", "Julio Pardo", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Garabatos", "Fali Pastrana", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Creaciones S.A.", "Nandi Migueles", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Cádiz resiste", "Sevilla Pecci", "Sevilla", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La Soñadora", "Victoriano Cano Pérez", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Coromía", "Nueva Agrupación", "Mérida", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("La Colonial", "David Fernández", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Al sonar las doce", "Luis Rivero", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Manos Arriba", "Valdés", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("El fantasma del tablao", "Longobardo", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Gloria Bendita", "Chapa y Procopio", "Cádiz", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp"),
				new Agrupacion("Los Superhombre", "Nueva Agrupación", "Sevilla", Modalidad.Coro, "https://i.ytimg.com/vi_webp/JCVmrxp7_mA/maxresdefault.webp")

				);
		
		for (Sesion s : sesiones) {
			sesionServicio.save(s);
		}
		
		for (Agrupacion a : agrupaciones) {
			agrupacionServicio.save(a);
		}
		
	}
}
