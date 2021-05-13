package com.salesianostriana.dam.holamundo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.holamundo.model.Agrupacion;
import com.salesianostriana.dam.holamundo.model.Sesion;
import com.salesianostriana.dam.holamundo.servicio.SesionService;

@Controller
public class SesionController {
	
	private SesionService sesionServicio;

	@GetMapping("/sesion")
	public String listarAgrupacionesSesionController (Model model) {
List<Agrupacion> lista = new ArrayList<Agrupacion>();
				
		model.addAttribute("agrupacionSesion", lista);
		return "sesion";
	}

	@GetMapping("/form-sesion")
	public String editarSesionController (Model model) {
		return "form-sesion";
	}
	
	@GetMapping("/nuevaSesion")
	public String muestraFormulario(Model model) {
		model.addAttribute("sesion", new Sesion());
		return "form-sesion";
	}
	
	@PostMapping("/nuevaSesion/submit")
	public String procesaFormulario(@ModelAttribute("sesion") Sesion sesion) {
		// SesionService.save(sesion);
		//Rediregimos al controlador index para que muestre el listado de 
		//alumnos con el que se acaba de añadir  
		return "redirect:/list-sesion";
	}

	
	@GetMapping("/list-sesion")
	public String listarSesionController (Model model) {
		return "list-sesion";
	}
}
