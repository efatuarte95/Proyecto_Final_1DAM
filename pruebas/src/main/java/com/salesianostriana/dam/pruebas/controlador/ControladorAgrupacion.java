package com.salesianostriana.dam.pruebas.controlador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ControladorAgrupacion {

	private final AgrupacionServicio servicio;
	private final SesionServicio sesionServicio;

	@GetMapping("/agrupacion")
	public String mostrarAgrupaciones(Model model) {
		model.addAttribute("agrupaciones", servicio.findAll());
		return "agrupacion";
	}

	@GetMapping("/list-agrupacion")
	public String listarAgrupacionesController(Model model) {
		model.addAttribute("modalidades", servicio.findAll());
		return "list-agrupacion";
	}

	@GetMapping("/form-agrupacion")
	public String showAgrupacionFormController(Model model) {
		Agrupacion agrupacion = new Agrupacion();
		model.addAttribute("agrupacionForm", agrupacion);
		return "form-agrupacion";
	}

	@PostMapping("/addAgrupacion")
	public String submit(@ModelAttribute("agrupacionForm") Agrupacion agrupacion, Model model) {
		// Se añade al modelo la agrupacion que se creará al recoger los datos del
		// formulario
		model.addAttribute("agrupacion", agrupacion);
		// Se muestra la página con la información mandada en el formulario al guardar
		return "redirect:/sesion";
	}

	@GetMapping("/agrupacion/{nombre}")
	public String mostrarInfoAgrupacionController(@PathVariable("nombre") String nombre, Model model) {
		//Buscamos el producto por 
		Agrupacion a = servicio.buscarPorNombre(nombre);
		//Si el producto no es null (si existe el producto buscado) se añade al modelo y mostramos la página del detalle detail.html
		//Si no existe, volvemos a la página index que vuelve a realizar todo lo que hace el método index
		if (a != null) {
			model.addAttribute("agrupacionInfo", a);
			return "info-agrupacion";
		}
		
		return "redirect:/";
	}

	@GetMapping("/clasificacion/{modalidad}")
	public String mostrarPuntosController(@PathVariable("modalidad") String modalidad, Model model) {
		List<Agrupacion> agrupaciones = servicio.mostrarMejoresAgrupaciones(modalidad);
		if (agrupaciones != null) {
			model.addAttribute("agrupacionClasificacion", agrupaciones);
			return "clasificacion";
		}
		return "redirect:/";
	}
	
	@GetMapping("/agrupacion/{nombre}/editar")
	public String editarAgrupacion(@PathVariable("nombre") String nombre, Model model) {

		Agrupacion agrupacion = servicio.buscarPorNombre(nombre);

		if (agrupacion != null) {
			model.addAttribute("agrupacion", agrupacion);
			return "/form-agrupacion";
		} else {
			return "redirect:/";
		}

	}
	
	@GetMapping("/agrupacion/{nombre}/borrar")
	public String borrarAgrupacion(@PathVariable("nombre") String nombre, Model model) {

		Agrupacion agrupacion = servicio.buscarPorNombre(nombre);
		if (agrupacion != null) {
			servicio.delete(agrupacion);
		}
		return "redirect:/";
	}
	
	@ModelAttribute("nombreSesiones")
	public List<String> listarNombreSesiones() {
		List<Sesion> nombreSesiones = sesionServicio.findAll();
		return nombreSesiones.stream()
				.map(x -> x.getNombre())
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
