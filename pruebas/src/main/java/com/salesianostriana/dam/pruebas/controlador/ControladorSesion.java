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
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sesion")
public class ControladorSesion {

	private final SesionServicio servicio;
	private final AgrupacionServicio agrupacionServicio;

	// Listar todas las sesiones
	@GetMapping("/")
	public String mostrarSesiones(Model model) {
		model.addAttribute("sesiones", servicio.findAll());
		return "list-sesion";
	}

	@GetMapping("/{nombre_sesion}")
	public String listarAgrupacionesSesionController(@PathVariable("nombre_sesion") String nombre, Model model) {
		List<Sesion> lista = new ArrayList<>();
		for (int i = 0; i < servicio.findAll().size(); i++) {
			if(servicio.findAll().get(i).getNombre().equals(nombre))
				lista.add(servicio.findAll().get(i));
		}
		model.addAttribute("sesiones", lista);
		return "sesion";
	}

	@GetMapping("/nueva")
	public String nuevaSesion(Model model) {
		model.addAttribute("sesion", new Sesion());
		return "form-sesion";
	}

	@PostMapping("/nueva/submit")
	public String submitNuevaSesion(@ModelAttribute("sesion") Sesion sesion, Model model) {
			servicio.save(sesion);
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editarSesion(@PathVariable("id") Long id, Model model) {
		Sesion sesion = servicio.findById(id);
		if (sesion != null) {
			model.addAttribute("sesion", sesion);
			return "form-sesion";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarSesion(@PathVariable("id") Long id, Model model) {
		
		Sesion sesion = servicio.findById(id);
		
		if (sesion != null) {
			if (servicio.numAgrupacionesSesion(sesion) == 0) {
				servicio.delete(sesion);				
			} else {
			//Se ha agregado el parámetro error con valor true a la ruta	
				return "redirect:/?error=true";
			}
			
		} 
		return "redirect:/";
	}

	@GetMapping("/{nombre_sesion}/{id}")
	public String listarSesionController(@PathVariable("nombre_sesion") String nombre, @PathVariable("nombre_sesion") long sesion_id, Model model) {
		List<Agrupacion> lista = new ArrayList<>();
		for (int i = 0; i < agrupacionServicio.findAll().size(); i++) {
			for (int j = 0; j < agrupacionServicio.findAll().get(i).getSesiones().size(); j++) {
				if(agrupacionServicio.findAll().get(i).getSesiones().get(j).getNombre().equals(nombre) && 
						agrupacionServicio.findAll().get(i).getSesiones().get(j).getSesion_id() == sesion_id)
					lista.add(agrupacionServicio.findAll().get(i));
			}
		}	
		model.addAttribute("agrupacionesSesion", lista);
		return "list-sesion";
	}

	@ModelAttribute("nombreSesiones")
	public List<String> listarNombreSesiones() {
		List<Sesion> nombreSesiones = servicio.findAll();
		return nombreSesiones.stream()
				.map(x -> x.getNombre())
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
