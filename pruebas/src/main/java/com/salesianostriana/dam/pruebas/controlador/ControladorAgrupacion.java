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

	@GetMapping("/agrupaciones")
	public String mostrarAgrupaciones(Model model) {
		model.addAttribute("agrupaciones", servicio.findAll());
		return "agrupacion";
	}

	@GetMapping("/{modalidad}/agrupaciones")
	public String listarAgrupacionesController(@PathVariable("modalidad") String modalidad, Model model) {		
		model.addAttribute("agrupaciones", servicio.mostrarAgrupacionesModalidad(modalidad));
		return "list-agrupacion";
	}

	@GetMapping("/agrupaciones/nueva")
	public String nuevaAgrupacion(Model model) {
		model.addAttribute("agrupacion", new Agrupacion());
		return "form-agrupacion";
	}

	@PostMapping("/agrupaciones/nueva/submit")
	public String submitNuevaAgrupacion(@ModelAttribute("agrupacion") Agrupacion agrupacion, Model model) {
			servicio.save(agrupacion);
		return "redirect:/";
	}

	@GetMapping("/agrupaciones/editar/{id}")
	public String editarAgrupacion(@PathVariable("id") Long id, Model model) {
		Agrupacion agrupacion = servicio.findById(id);
		if (agrupacion != null) {
			model.addAttribute("agrupacion", agrupacion);
			model.addAttribute("sesiones", sesionServicio.findAll());
			return "form-agrupacion";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/agrupaciones/borrar/{id}")
	public String borrarAgrupacion(@PathVariable("id") Long id, Model model) {
		
		Agrupacion agrupacion = servicio.findById(id);
		
		if (agrupacion != null) {
			servicio.delete(agrupacion);
		}

		return "redirect:/";
	}

	@GetMapping("/agrupacion/{nombre}")
	public String mostrarInfoAgrupacion(@PathVariable("nombre") String nombre, Model model) {
		Agrupacion agrupacion = servicio.buscarPorNombre(nombre);
		if (agrupacion != null) {
			model.addAttribute("agrupacionInfo", agrupacion);
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
