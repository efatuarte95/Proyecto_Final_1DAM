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

import com.salesianostriana.dam.pruebas.modelo.Agrupacion;
import com.salesianostriana.dam.pruebas.modelo.Modalidad;
import com.salesianostriana.dam.pruebas.modelo.Sesion;
import com.salesianostriana.dam.pruebas.servicio.AgrupacionServicio;
import com.salesianostriana.dam.pruebas.servicio.SesionServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ControladorSesion {

	private final SesionServicio servicio;
	private final AgrupacionServicio agrupacionServicio;

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
	
	@GetMapping("/form-sesion")
	public String editarSesionController(Model model) {
		return "form-sesion";
	}

	@GetMapping("/nuevaSesion")
	public String muestraFormulario(Model model) {
		model.addAttribute("sesion", new Sesion());
		return "form-sesion";
	}

	@PostMapping("/nuevaSesion/submit")
	public String procesaFormulario(@ModelAttribute("sesion") Sesion sesion) {
			servicio.save(sesion);
		// Rediregimos al controlador list-sesion para que muestre el listado de
		// sesiones con el que se acaba de añadir
		return "redirect:/list-sesion";
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
