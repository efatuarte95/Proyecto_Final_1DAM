package com.salesianostriana.dam.pruebas.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.modelo.TipoSesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

/**
 * En esta clase se establecen las rutas y métodos relacionados con las agrupaciones del concurso
 * @author Ernesto Fatuarte
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
public class ControladorAgrupacion {

	// Inyectamos las dependencias con los servicios
	private final AgrupacionServicio servicio;
	private final SesionServicio sesionServicio;

	/**
	 * El siguiente método sirve para listar todas las agrupaciones existentes, añadiendo una opción para buscar por el nombre de las mismas
	 * @param consulta El texto introducido en el buscador
	 * @param model
	 * @return Devuelve la plantilla que pinta este listado
	 */
	@GetMapping("/agrupaciones")
	public String mostrarAgrupaciones(@RequestParam("q") Optional<String> consulta, Model model) {
		List<Agrupacion> agrupacionesResult;
		
		// Si no introducimos nada en el buscador, se nos devolverán todas las agrupaciones
		if(consulta.isEmpty())
			agrupacionesResult = servicio.findAll();
		else
			// si no, solo nos traerá un listado de aquellas que contengan lo introducido en el nombre de la agrupación
			agrupacionesResult = servicio.busquedaPorNombre(consulta.get());
		
		model.addAttribute("agrupaciones", agrupacionesResult);
		return "agrupacion";
	}

	/**
	 * El siguiente método sirve para listar las agrupaciones de una modalidad concreta
	 * @param modalidad La modalidad que queremos consultar
	 * @param model
	 * @return Devuelve la plantilla que imprime la lista
	 */
	@GetMapping("/agrupaciones/{modalidad}")
	public String listarAgrupacionesController(@PathVariable("modalidad") Modalidad modalidad, Model model) {				
		model.addAttribute("agrupaciones", servicio.todasLasAgrupacionesDeUnaModalidad(modalidad));
		model.addAttribute("modalidad", modalidad);
		return "list-agrupacion";
	}

	/**
	 * El siguiente método sirve para introducir los datos a la hora de crear una nueva agrupación
	 * @param model
	 * @return Devuelve la plantilla del formulario vacío
	 */
	@GetMapping("/agrupacion/nueva")
	public String nuevaAgrupacion(Model model) {
		model.addAttribute("agrupacionForm", new Agrupacion());
		return "form-agrupacion";
	}

	/**
	 * El siguiente método sirve para guardar la nueva agrupacion en la base de datos
	 * @param agrupacion la agrupación que se ha creado
	 * @return Nos redirige al listado de agrupaciones
	 */
	@PostMapping("/agrupacion/nueva/submit")
	public String submitNuevaAgrupacion(@ModelAttribute("agrupacionForm") Agrupacion agrupacion) {
			servicio.save(agrupacion);
		return "redirect:/agrupaciones";
	}

	/**
	 * El siguiente método sirve para editar una agrupación
	 * @param agrupacion_id El id de la agrupacion que queremos editar
	 * @param model
	 * @return Devuelve el formulario de una agrupación con sus campos rellenos
	 */
	@GetMapping("/agrupacion/editar/{agrupacion_id}")
	public String editarAgrupacion(@PathVariable("agrupacion_id") Long agrupacion_id, Model model) {
		Agrupacion agrupacion = servicio.findById(agrupacion_id);
		if (agrupacion != null) {
			model.addAttribute("agrupacionForm", agrupacion);
			model.addAttribute("sesiones", sesionServicio.findAll());
			return "form-agrupacion";
		} else
			return "redirect:/calendario";
	}
	
	@GetMapping("/agrupacion/borrar/{agrupacion_id}")
	public String borrarAgrupacion(@PathVariable("agrupacion_id") Long agrupacion_id, Model model) {
		
		Agrupacion agrupacion = servicio.findById(agrupacion_id);
		
		if (agrupacion != null) {
			servicio.delete(agrupacion);
		}

		return "redirect:/agrupaciones";
	}

//	@GetMapping("/agrupacion/{nombre}")
//	public String mostrarInfoAgrupacion(@PathVariable("nombre") String nombre, Model model) {
//		Agrupacion agrupacion = servicio.buscarPorNombre(nombre);
//		if (agrupacion != null) {
//			model.addAttribute("agrupacionInfo", agrupacion);
//			return "info-agrupacion";
//		}
//		return "redirect:/";
//	}
	
	@GetMapping("/agrupacion/{agrupacion_id}")
	public String mostrarInfoAgrupacion(@PathVariable("agrupacion_id") Long agrupacion_id, Model model) {
		Agrupacion agrupacion = servicio.findById(agrupacion_id);
		if (agrupacion != null) {
			model.addAttribute("agrupacion", agrupacion);
			return "info-agrupacion";
		}
		return "redirect:/";
	}

	@GetMapping("/clasificacion/{modalidad}")
	public String mostrarPuntosController(@RequestParam("q") Optional<String> consulta, @PathVariable("modalidad") Modalidad modalidad, Model model) {
		List<Agrupacion> agrupaciones = servicio.mostrarMejoresAgrupaciones(modalidad);
		List<Agrupacion> agrupacionesResult;
		
		if (agrupaciones != null) {
			model.addAttribute("agrupacionClasificacion", agrupaciones);
			model.addAttribute("modalidad", modalidad);
			return "clasificacion";
		}
		
		if(consulta.isEmpty())
			agrupacionesResult = servicio.findAll();
		else
			agrupacionesResult = servicio.busquedaPorNombre(consulta.get());
		model.addAttribute("agrupacionesConsulta", agrupacionesResult);
		
		return "redirect:/";
	}
		
	@ModelAttribute("tipoSesiones")
	public List<TipoSesion> listartipoSesiones() {
		List<Sesion> tipoSesiones = sesionServicio.findAll();
		return tipoSesiones.stream()
				.map(x -> x.getTipoSesion())
				.distinct()
				.collect(Collectors.toList());
	}
	
	@ModelAttribute("modalidades")
	public List<Modalidad> listarNombreModalidades() {
		List<Agrupacion> nombreModalidad = servicio.findAll();
		return nombreModalidad.stream()
				.map(x -> x.getModalidad())
				.distinct()
				.collect(Collectors.toList());
	}

}
