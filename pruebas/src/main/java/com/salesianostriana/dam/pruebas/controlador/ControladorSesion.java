package com.salesianostriana.dam.pruebas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.AgrupacionSesion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.modelo.TipoSesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionSesionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sesion")
public class ControladorSesion {

	private final SesionServicio servicio;
	private final AgrupacionServicio agrupacionServicio;
	private final AgrupacionSesionServicio agrSesionServicio;

	// Listar todas las sesiones
	@GetMapping("/")
	public String mostrarSesiones(Model model) {
		model.addAttribute("sesiones", servicio.findAll());
		return "list-sesion";
	}

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

	@GetMapping("/nueva")
	public String nuevaSesion(Model model) {
		model.addAttribute("sesionForm", new Sesion());
		return "form-sesion";
	}

	@PostMapping("/nueva/submit")
	public String submitNuevaSesion(@ModelAttribute("sesionForm") Sesion sesion, Model model) {
			servicio.save(sesion);
		return "redirect:/calendario";
	}

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
	
	@GetMapping("/borrar/{sesion_id}")
	public String borrarSesion(@PathVariable("sesion_id") Long sesion_id, Model model) {
		
		Sesion sesion = servicio.findById(sesion_id);
		
		if (sesion != null) {
			if (servicio.numAgrupacionesSesion(sesion) == 0) {
				servicio.delete(sesion);				
			} else {
			//Se ha agregado el parámetro error con valor true a la ruta	
				return "redirect:/?error=true";
			}
			
		} 
		return "redirect:/calendario";
	}

	@GetMapping("/{tipoSesion}/{sesion_id}")
	public String listarSesionController(@PathVariable("sesion_id") long sesion_id, @PathVariable("tipoSesion") TipoSesion tipoSesion, Model model) {
		List<Agrupacion> lista = new ArrayList<>();
		for (int i = 0; i < agrupacionServicio.findAll().size(); i++) {
			for (int j = 0; j < agrupacionServicio.findAll().get(i).getSesiones().size(); j++) {
				if(agrupacionServicio.findAll().get(i).getSesiones().get(j).getTipoSesion().equals(tipoSesion) && 
						agrupacionServicio.findAll().get(i).getSesiones().get(j).getSesion_id() == sesion_id)
					lista.add(agrupacionServicio.findAll().get(i));
			}
		}	
		model.addAttribute("agrupacionesSesion", lista);
		model.addAttribute("tipoSesion", tipoSesion);
		return "sesion";
	}
	
	@GetMapping("{tipoSesion}/{sesion_id}/nueva/agrupacion")
	public String agregarAgrupacionASesion(@PathVariable("sesion_id") long sesion_id, @PathVariable("tipoSesion") TipoSesion tipoSesion, Model model, AgrupacionSesion as) {
		agrSesionServicio.agregarAgrupacionSesion(as.getAgrupacion_id(), as.getSesion_id());
		model.addAttribute("agrupacionSesion", new AgrupacionSesion());
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
	
	@PostMapping("/nueva/agrupacion/submit")
	public String submitNuevaAgrupacionSesion(@ModelAttribute("agrupacionSesionForm") Sesion sesion, Model model) {
			//sesion.addAgrupacion();
		return "redirect:/calendario";
	}

	@ModelAttribute("tipoSesiones")
	public List<TipoSesion> listartipoSesiones() {
		List<Sesion> tipoSesiones = servicio.findAll();
		return tipoSesiones.stream()
				.map(x -> x.getTipoSesion())
				.distinct()
				.collect(Collectors.toList());
	}
	
	@ModelAttribute("modalidades")
	public List<Modalidad> listarNombreModalidades() {
		List<Agrupacion> nombreModalidad = agrupacionServicio.findAll();
		return nombreModalidad.stream()
				.map(x -> x.getModalidad())
				.distinct()
				.collect(Collectors.toList());
	}
	
}
