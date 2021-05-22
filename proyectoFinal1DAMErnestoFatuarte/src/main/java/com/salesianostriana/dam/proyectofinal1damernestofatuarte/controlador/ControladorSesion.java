package com.salesianostriana.dam.proyectofinal1damernestofatuarte.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Agrupacion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Modalidad;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.Sesion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.modelo.TipoSesion;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio.AgrupacionServicio;
import com.salesianostriana.dam.proyectofinal1damernestofatuarte.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;
/**
 * En esta clase estableceremos las rutas relacionadas con las sesiones y los comportamientos que tendrá la aplicación en cada una de ellas
 * @author Ernesto Fatuarte
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/sesion")
public class ControladorSesion {

	// Inyectamos ambos servicios
	private final SesionServicio servicio;
	private final AgrupacionServicio agrupacionServicio;

	/**
	 * El siguiente método nos muestra las sesiones de un tipo de sesión concreta
	 * @param tipoSesion El tipo de sesión seleccionada
	 * @param model
	 * @return Devuelve la plantilla de listado de sesiones
	 */
	@GetMapping("/{tipoSesion}")
	public String listarAgrupacionesSesionController(@PathVariable("tipoSesion") TipoSesion tipoSesion, Model model) {
		List<Sesion> lista = new ArrayList<>();
		for (int i = 0; i < servicio.findAll().size(); i++) {
			if(servicio.findAll().get(i).getTipoSesion().equals(tipoSesion))
				lista.add(servicio.findAll().get(i));
		}
		model.addAttribute("sesiones", lista);
		model.addAttribute("tipoSesion", tipoSesion);
		return "list-sesion";
	}

	/**
	 * El siguiente método sirve para añadir una nueva sesión
	 * @param model
	 * @return Devuelve el formulario de sesion
	 */ 
	@GetMapping("/nueva")
	public String nuevaSesion(Model model) {
		model.addAttribute("sesionForm", new Sesion());
		return "form-sesion";
	}

	/**
	 * El siguiente método sirve para enviar los datos del formulario de sesión
	 * @param sesion La sesión que hemos creado
	 * @param model
	 * @return Se nos redirige a la lista de sesiones
	 */
	@PostMapping("/nueva/submit")
	public String submitNuevaSesion(@ModelAttribute("sesionForm") Sesion sesion, Model model) {
			servicio.save(sesion);
		return "redirect:/calendario";
	}

	/**
	 * El siguiente método sirve para editar una sesión concreta
	 * @param sesion_id El id de la sesión que queremos editar
	 * @param model
	 * @return Devuelve el formulario de sesion con los datos rellenos
	 */
	@GetMapping("/editar/{sesion_id}")
	public String editarSesion(@PathVariable("sesion_id") Long sesion_id, Model model) {
		Sesion sesion = servicio.findById(sesion_id);
		if (sesion != null) {
			model.addAttribute("sesionForm", sesion);
			return "form-sesion";
		} else {
			return "redirect:/calendario";
		}
	}
	
	/**
	 * El siguiente método sirve para borrar una sesión, comprobando previamente si tiene agrupaciones asociadas
	 * @param sesion_id El id de la sesión que queremos borrar
	 * @param model
	 * @return Nos redirige a la lista de sesiones
	 */
	@GetMapping("/borrar/{sesion_id}")
	public String borrarSesion(@PathVariable("sesion_id") long sesion_id, Model model) {
		
		Sesion sesion = servicio.findById(sesion_id);
		
		if (sesion != null) {
			if (sesion.getAgrupaciones().size() == 0) {
				servicio.delete(sesion);				
			} else {
			//Se ha agregado el parámetro error con valor true a la ruta	
				return "redirect:/?error=true";
			}
			
		} 
		return "redirect:/calendario";
	}

	/**
	 * En este método crearemos una lista de las agrupaciones que pertenen a la sesión seleccionada y mezclaremos sus elementos para crear una sesión
	 * @param sesion_id El id de la sesion seleccionada
	 * @param tipoSesion El tipo de la sesión seleccionada
	 * @param model
	 * @return Devolvemos la plantilla necesaria
	 */
	@GetMapping("/{tipoSesion}/{sesion_id}")
	public String listarSesionController(@PathVariable("sesion_id") long sesion_id, @PathVariable("tipoSesion") TipoSesion tipoSesion, Model model) {
		List<Agrupacion> lista = new ArrayList<>();
		Sesion sesion = servicio.findById(sesion_id);
		// Creo una lista auxiliar donde guardo las agrupaciones pertenecientes a la sesion encontrada
		List<Agrupacion> listAux = agrupacionServicio.listarAgrupacionesSesion(sesion);
		
		// Mezclo los elementos
		Collections.shuffle(listAux);
		
		// Convierto a lista el resultado anterior
		lista = listAux.stream().collect(Collectors.toList());
		
		// Paso al modelo la información anterior
		model.addAttribute("agrupacionesSesion", lista);
		model.addAttribute("tipoSesion", tipoSesion);
		model.addAttribute("fecha", sesion.getFecha());
		return "sesion";
	}
	
	/**
	 * El siguiente método nos permite añadir una agrupación a la sesión indicada
	 * @param sesion_id El id de la sesión
	 * @param tipoSesion El tipo de sesión
	 * @param model
	 * @return Nos devuelve la plantilla del formulario y si no existe la sesión nos lleva al listado de sesiones
	 */
	@GetMapping("{tipoSesion}/{sesion_id}/nueva/agrupacion")
	public String agregarAgrupacionASesion(@PathVariable("sesion_id") long sesion_id, @PathVariable("tipoSesion") TipoSesion tipoSesion, Model model) {
		Sesion sesion = servicio.findById(sesion_id);
		if (sesion != null) {
			model.addAttribute("agrupacionSesionForm", sesion);
			model.addAttribute("agrupaciones", agrupacionServicio.findAll());
			return "form-sesion-agrupacion";
		} 
		else {
			return "redirect:/calendario";
		}
	}
	
	/**
	 * El siguiente método sirve para guardar los datos que provienen del formulario
	 * @param sesion La sesión la cual hemos rellenado 
	 * @param model
	 * @return Nos redirige al listado de sesiones
	 */
	@PostMapping("/nueva/agrupacion/submit")
	public String submitNuevaAgrupacionSesion(@ModelAttribute("agrupacionSesionForm") Sesion sesion, Model model) {
			//sesion.addAgrupacion();
		return "redirect:/calendario";
	}

	/**
	 * El siguiente método sirve para editar una agrupación
	 * @param agrupacion_id El id de la agrupacion que queremos editar
	 * @param model
	 * @return Devuelve el formulario de una agrupación con sus campos rellenos
	 */
	@GetMapping("/agrupacion/editar/{agrupacion_id}")
	public String editarAgrupacion(@PathVariable("agrupacion_id") Long agrupacion_id, Model model) {
		Agrupacion agrupacion = agrupacionServicio.findById(agrupacion_id);
		if (agrupacion != null) {
			model.addAttribute("agrupacionForm", agrupacion);
			model.addAttribute("sesiones", servicio.findAll());
			return "form-agrupacionPuntos";
		} else
			return "redirect:/agrupaciones";
	}
	
	/**
	 * El siguiente método sirve para guardar la nueva agrupacion en la base de datos
	 * @param agrupacion la agrupación que se ha creado
	 * @return Nos redirige al listado de agrupaciones
	 */
	@PostMapping("/agrupacion/nueva/submit")
	public String submitNuevaAgrupacion(@ModelAttribute("agrupacionForm") Agrupacion agrupacion) {
			agrupacionServicio.save(agrupacion);
		return "redirect:/agrupaciones";
	}
	
	/**
	 * Con este método guardamos en el modelo los tipos de sesiones guardadas
	 * @return Una lista con los tipos de las sesiones 
	 */
	@ModelAttribute("tipoSesiones")
	public List<TipoSesion> listartipoSesiones() {
		List<Sesion> tipoSesiones = servicio.findAll();
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
