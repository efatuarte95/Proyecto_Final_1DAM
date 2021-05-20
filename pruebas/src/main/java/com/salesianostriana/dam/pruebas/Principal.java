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
		
		// Guardo las sesiones
		sesiones.forEach(sesionServicio::save);
		
		List<Agrupacion> agrupaciones = List.of(
			// Creamos comparsas de ejemplo
			new Agrupacion("La Chusma Selecta", "Martínez Ares", "Cádiz", Modalidad.Comparsa, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/01/arestocracia-chusma-selecta-ares.jpg"),
			new Agrupacion("¡Oh capitán, my capitán!", "Tino Tovar", "Cádiz", Modalidad.Comparsa, "https://www.codigocarnaval.com/wp-content/uploads/2019/10/Comparsa-oh-capitan-my-capitan.jpg"),
			new Agrupacion("La Canción de la Laguna", "David Carapapa", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi/zJld1MZCDmA/maxresdefault.jpg"),
			new Agrupacion("Los Listos", "Chapa y Aranda", "Cádiz", Modalidad.Comparsa, "https://www.codigocarnaval.com/wp-content/uploads/2019/10/Comparsa-Los-Listos.jpg"),
			new Agrupacion("Los Encaidenaos", "Kike Remolino", "Sevilla", Modalidad.Comparsa, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/02/comparsa-los-encaidenaos.jpg"),
			new Agrupacion("Los Tocaos del Ala", "El Lacio", "Huelva", Modalidad.Comparsa, "https://www.huelvainformacion.es/2020/02/14/huelva/Imagenes-comparsa-tocaos-ala_1437466698_117015127_640x360.jpg"),
			new Agrupacion("La Ciudad de Dios", "Jesús Pérez Fuentes", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi/u-J8fwCBDEk/maxresdefault.jpg"),
			new Agrupacion("Los Pacientes", "Fran Quintana", "Cádiz", Modalidad.Comparsa, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/02/pacientes6_xoptimizadax-650x400.jpg"),
			new Agrupacion("Los Majaras", "Nono Galán", "Conil", Modalidad.Comparsa, "https://www.codigocarnaval.com/wp-content/uploads/2019/10/Comparsa-los-majaras.jpg"),
			new Agrupacion("La tierra de la alegría", "Jesús Monje", "Cádiz", Modalidad.Comparsa, "https://www.codigocarnaval.com/wp-content/uploads/2019/11/comparsa-la-tierra-de-la-alegria.jpg"),
			new Agrupacion("Los Resilientes", "Germán Rendón", "Algeciras", Modalidad.Comparsa, "https://www.lavozdigital.es/media/MM/2020/02/03/v/comparsa-los-resilientes(1)_xoptimizadax.jpg"),
			new Agrupacion("Los Aislados", "Jonathan Pérez", "Cádiz", Modalidad.Comparsa, "https://i.ytimg.com/vi/NkdDvr0bhnI/maxresdefault.jpg"),
			new Agrupacion("El Arenero", "David Campano López", "Cádiz", Modalidad.Comparsa, ""),
			new Agrupacion("Los Últimos Poetas", "Lolo Barragán", "Huelva", Modalidad.Comparsa, ""),
			new Agrupacion("El gran dictador", "Juanma Hernández", "Cádiz", Modalidad.Comparsa, ""),
			new Agrupacion("Hospital Febrero", "José María Fernández Garrido", "Córdoba", Modalidad.Comparsa, ""),
			new Agrupacion("Los Traicioneros", "Jose Javier Puerto", "Cádiz", Modalidad.Comparsa, ""),
			new Agrupacion("La Superviviente", "Darío Falcón", "Cádiz", Modalidad.Comparsa, ""),
			new Agrupacion("Los Primerizzos", "David Príncipe", "Sevilla", Modalidad.Comparsa, ""),
			new Agrupacion("Sólo sé que no sé nada", "Borja Romero", "Cádiz", Modalidad.Comparsa, ""),
			
		// Creamos chirigotas de ejemplo
			new Agrupacion("Los Cadizfornia", "Vera Luque", "Cádiz", Modalidad.Chirigota, "http://ocadizdigital.es/sites/default/files/agrupaciones/060220-los%20cadizfornia-027l.jpg"),
			new Agrupacion("Estrés por Cuatro", "El Selu", "Cádiz", Modalidad.Chirigota, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/02/chirigota-estres-por-cuatro.jpg"),
			new Agrupacion("Los niños de la Petróleo", "Sheriff", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi/DZkcdt4k2gk/maxresdefault.jpg"),
			new Agrupacion("Los Gipsy Scream", "Jesús Benárquez", "Sevilla", Modalidad.Chirigota, "https://amp.canalsur.es/resources/archivos_offline/2020/2/16/1581893570166Chirigota_LosGipsyScream_Semifinales_1024x576.jpg"),
			new Agrupacion("Chernobyl, el musical", "El Canijo de Carmona", "Sevilla", Modalidad.Chirigota, "https://www.diariodecadiz.es/2020/01/24/diario_del_carnaval/Chirigota-Chernobyl-Musical_1431167654_115754603_667x375.jpg"),
			new Agrupacion("Pídeme lo que tu quieras", "Los Molina", "Cádiz", Modalidad.Chirigota, "https://i.ytimg.com/vi/5YfGd7n3jEY/maxresdefault.jpg"),
			new Agrupacion("Dio Picha!", "Juan Carlos Aragón", "Cádiz", Modalidad.Chirigota, "https://www.lavozdigital.es/media/MM/2020/01/28/v/dio-picha(4)-kDyG--1350x900@abc.JPG"),
			new Agrupacion("Los Couchers LowCost", "El Bizcocho", "San José de la Rinconada", Modalidad.Chirigota, "https://www.diariodesevilla.es/2020/01/29/vivirensevilla/couchers-lowcost-felicidad-completa-Falla_1432676758_116044966_1200x675.jpg"),
			new Agrupacion("Aquí estamos de paso", "Cascana", "Cádiz", Modalidad.Chirigota, "https://www.diariodecadiz.es/2020/02/20/diario_del_carnaval/chirigota-paso-actuacion-semifinales_1439266312_117336816_667x375.jpg"),
			new Agrupacion("Los Geni de Cádiz", "Jose Miguel Choza", "Isla Cristina", Modalidad.Chirigota, "http://ocadizdigital.es/sites/default/files/carnaval/articulos/190220-los%20geni%20de%20cadi-120.jpg"),
			new Agrupacion("No aguantamos más, vamos de impacientes", "Fermín Coto", "Cádiz", Modalidad.Chirigota, "https://cdn.wegow.com/media/artists/chirigota-no-aguantamos-mas-vamos-de-impacientes/chirigota-no-aguantamos-mas-vamos-de-impacientes-1582188817.3879168.2560x1440.jpg"),
			new Agrupacion("Los hijos del Carota", "Jose Manuel Martínez", "Conil", Modalidad.Chirigota, ""),
			new Agrupacion("Los Viejos del Parque", "Juan Francisco Castro", "Cádiz", Modalidad.Chirigota, ""),
			new Agrupacion("Las Yeni Walker", "Jose Manuel Ramírez", "Cádiz", Modalidad.Chirigota, ""),
			new Agrupacion("No te gusta ná José", "Jose Miguel Choza", "Cádiz", Modalidad.Chirigota, ""),
			new Agrupacion("¿Qué disse Cabessa?", "Roberto Leal", "Sevilla", Modalidad.Chirigota, ""),
			new Agrupacion("Las Eventuales", "Luis Rossi", "Cádiz", Modalidad.Chirigota, ""),
			new Agrupacion("Los 7 locos", "David Amaya", "Cádiz", Modalidad.Chirigota, ""),
			new Agrupacion("Los Joaquin Dead", "Jose María Parrado", "Cádiz", Modalidad.Chirigota, ""),
			new Agrupacion("Los de la Resistencia", "Cárdenas y Peñalver", "Los Palacios", Modalidad.Chirigota, ""),
			
		// Creamos cuartetos de ejemplo
			new Agrupacion("Aquí no hace frío, aquí hace humedad", "David Reyes", "Cádiz", Modalidad.Cuarteto, "https://static3.lavozdigital.es/media/MM/2020/01/28/v/cuarteto-aqui-no-hace-frio-hace-humedad(3)-kAQC--1248x698@abc.jpg"),
			new Agrupacion("Vida y Obra de JC1, Bajo D", "El Gago", "Cádiz", Modalidad.Cuarteto, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/02/vida-obra-juancarlos-3.jpg"),
			new Agrupacion("Cari, resiste", "Javi Aguilera", "Sevilla", Modalidad.Cuarteto, "https://www.elbuscadordelfalla.com/documentos/agrupaciones/07696_2_2020cari-resiste1.jpg"),
			new Agrupacion("El cuarteto del More", "Iván Romero", "Cádiz", Modalidad.Cuarteto, "https://www.codigocarnaval.com/wp-content/uploads/2019/12/cuarteto-el-cuarteto-del-more.jpg"),
			new Agrupacion("Merda Merda, mucha Merda", "Nueva Agrupación", "Huelva", Modalidad.Cuarteto, ""),
			new Agrupacion("Brigada Amarilla, Agüita con nojotro", "El Morera", "Cadi Cadi", Modalidad.Cuarteto, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2019/02/cuarteto-brigada-amarilla-recortada.jpg"),
			new Agrupacion("Vaya papa traemos", "Nueva Agrupación", "Conil", Modalidad.Cuarteto, ""),

		// Creamos coros de ejemplo
			new Agrupacion("Tócame", "Julio Pardo", "Cádiz", Modalidad.Coro, "https://www.diariodecadiz.es/2020/01/26/diario_del_carnaval/Coro-Tocame_1431766816_115835133_667x375.jpg"),
			new Agrupacion("Los Garabatos", "Fali Pastrana", "Cádiz", Modalidad.Coro, "https://ocadizdigital.es/sites/default/files/carnaval/articulos/130220-los%20garabatos-084.jpg"),
			new Agrupacion("Creaciones S.A.", "Nandi Migueles", "Cádiz", Modalidad.Coro, "https://www.codigocarnaval.com/wp-content/uploads/2019/11/Coro-Creaciones-SA.jpg"),
			new Agrupacion("Cádiz resiste", "Sevilla Pecci", "Sevilla", Modalidad.Coro, "https://www.lavozdigital.es/media/MM/2020/01/31/v/cadiz-resiste(6)_xoptimizadax.jpg"),
			new Agrupacion("La Soñadora", "Victoriano Cano Pérez", "Cádiz", Modalidad.Coro, "https://www.lavozdigital.es/media/MM/2020/02/05/v/sonadora(6)_xoptimizadax.jpg"),
			new Agrupacion("Coromía", "Nueva Agrupación", "Mérida", Modalidad.Coro, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/01/coro-coromia-e1580155133859-650x400.jpeg"),
			new Agrupacion("La Colonial", "David Fernández", "Cádiz", Modalidad.Coro, "https://carnaval.lavozdigital.es/wp-content/uploads/sites/15/2020/02/coro-la-colonial-recortada.jpg"),
			new Agrupacion("Al sonar las doce", "Luis Rivero", "Cádiz", Modalidad.Coro, "https://www.codigocarnaval.com/wp-content/uploads/2019/10/Coro-Al-sonar-las-doce.jpg"),
			new Agrupacion("Manos Arriba", "Valdés", "Cádiz", Modalidad.Coro, ""),
			new Agrupacion("El fantasma del tablao", "Longobardo", "Cádiz", Modalidad.Coro, ""),
			new Agrupacion("Gloria Bendita", "Chapa y Procopio", "Cádiz", Modalidad.Coro, ""),
			new Agrupacion("Los Superhombre", "Nueva Agrupación", "Sevilla", Modalidad.Coro, "https://www.lavozdigital.es/media/MM/2020/02/15/v/superhombres(9)_xoptimizadax.jpg")

		);
		
		// Guardo las agrupaciones
		agrupaciones.forEach(agrupacionServicio::save);
		
	}
}
