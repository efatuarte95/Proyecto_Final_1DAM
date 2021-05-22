package com.salesianostriana.dam.proyectofinal1damernestofatuarte.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Agrupacion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Modalidad;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Sesion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.TipoSesion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio.AgrupacionServicio;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

/**
 * En esta clase vamos a establecer las rutas y métodos relacionados con la página principal
 * @author Ernesto Fatuarte
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
public class ControladorPrincipal {
	
	// Inyectamos ambos servicios
	private final AgrupacionServicio agrupacionServicio;
	private final SesionServicio sesionServicio;
	
	/**
	 * Establecemos la ruta para la página principal
	 * @param model
	 * @return Devuelve la plantilla principal
	 */
	@GetMapping("/")
	public String inicioController (Model model){
		return "home";
	}

	/**
	 * Establecemos la ruta para la página de radio
	 * @param model
	 * @return Devuelve la plantilla de radio
	 */
	@GetMapping("/radio")
	public String mostrarRadioController (Model model) {
		return "radio";
	}
	
	/**
	 * El siguiente método sirve para listar todas las sesiones existentes
	 * @param model
	 * @return Devuelve la plantilla con todas las sesiones
	 */
	@GetMapping("/calendario")
	public String mostrarCalendario (Model model) {
		model.addAttribute("sesiones", sesionServicio.findAll());
		return "calendario";
	}
	
	/**
	 * Creamos una lista con los tipos de sesiones que existen y lo añadimos al modelo
	 * @return Una lista con los tipos de sesiones
	 */
	@ModelAttribute("tipoSesiones")
	public List<TipoSesion> listartipoSesiones() {
		List<Sesion> tipoSesiones = sesionServicio.findAll();
		return tipoSesiones.stream()
				.map(x -> x.getTipoSesion())
				.distinct()
				.collect(Collectors.toList());
	}
	
	/**
	 * Creamos una lista con las modalidades de agrupaciones que existen y lo añadimos al modelo
	 * @return Una lista con las modalidades
	 */
	@ModelAttribute("modalidades")
	public List<Modalidad> listarNombreModalidades() {
		List<Agrupacion> nombreModalidad = agrupacionServicio.findAll();
		return nombreModalidad.stream()
				.map(x -> x.getModalidad())
				.distinct()
				.collect(Collectors.toList());
	}

}
