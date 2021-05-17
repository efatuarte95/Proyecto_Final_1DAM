package com.salesianostriana.dam.pruebas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
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
		List<Agrupacion> lista = new ArrayList<>();
		for (int i = 0; i < agrupacionServicio.findAll().size(); i++) {
			if(agrupacionServicio.findAll().get(i).getSesiones().contains(nombre))
				lista.add(agrupacionServicio.findAll().get(i));
		}
		
		model.addAttribute("agrupacionesSesion", lista);
		return "sesion";
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

	@GetMapping("/list-sesion/{sesion}/{id}")
	public String listarSesionController(Model model) {
		model.addAttribute("sesiones", servicio.findAll());
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
