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

@Controller
@RequiredArgsConstructor
public class ControladorAgrupacion {

	private final AgrupacionServicio servicio;
	private final SesionServicio sesionServicio;

	@GetMapping("/agrupaciones")
	public String mostrarAgrupaciones(@RequestParam("q") Optional<String> consulta, Model model) {
		List<Agrupacion> agrupacionesResult;
		
		if(consulta.isEmpty())
			agrupacionesResult = servicio.findAll();
		else
			agrupacionesResult = servicio.busquedaPorNombre(consulta.get());
		
		model.addAttribute("agrupaciones", agrupacionesResult);
		return "agrupacion";
	}

	@GetMapping("/agrupaciones/{modalidad}")
	public String listarAgrupacionesController(@RequestParam("q") Optional<String> consulta, @PathVariable("modalidad") Modalidad modalidad, Model model) {		
		List<Agrupacion> agrupacionesResult;
		
		if(consulta.isEmpty())
			agrupacionesResult = servicio.findAll();
		else
			agrupacionesResult = servicio.busquedaPorNombre(consulta.get());
		model.addAttribute("agrupacionesConsulta", agrupacionesResult);
		
		model.addAttribute("agrupaciones", servicio.todasLasAgrupacionesDeUnaModalidad(modalidad));
		model.addAttribute("modalidad", modalidad);
		return "list-agrupacion";
	}

	@GetMapping("/agrupacion/nueva")
	public String nuevaAgrupacion(Model model) {
		model.addAttribute("agrupacionForm", new Agrupacion());
		return "form-agrupacion";
	}

	@PostMapping("/agrupacion/nueva/submit")
	public String submitNuevaAgrupacion(@ModelAttribute("agrupacionForm") Agrupacion agrupacion) {
			servicio.save(agrupacion);
		return "redirect:/";
	}

	@GetMapping("/agrupacion/editar/{agrupacion_id}")
	public String editarAgrupacion(@PathVariable("agrupacion_id") Long agrupacion_id, Model model) {
		Agrupacion agrupacion = servicio.findById(agrupacion_id);
		if (agrupacion != null) {
			model.addAttribute("agrupacion", agrupacion);
			model.addAttribute("sesiones", sesionServicio.findAll());
			return "form-agrupacion";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/agrupacion/borrar/{agrupacion_id}")
	public String borrarAgrupacion(@PathVariable("agrupacion_id") Long agrupacion_id, Model model) {
		
		Agrupacion agrupacion = servicio.findById(agrupacion_id);
		
		if (agrupacion != null) {
			servicio.delete(agrupacion);
		}

		return "redirect:/";
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
