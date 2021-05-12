package com.salesianostriana.dam.holamundo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgrupacionController {

	@GetMapping("/agrupacion")
	public String mostrarAgrupaciones(Model model) {
		return "agrupacion";
	}
	
	@GetMapping("/list-agrupacion")
	public String listarAgrupacionesController (Model model) {
		return "list-agrupacion";
	}
	
	@GetMapping("/form-agrupacion")
	public String editarAgrupacionController (Model model) {
		return "form-agrupacion";
	}

	@GetMapping("/info-agrupacion")
	public String mostrarInfoAgrupacionController (Model model) {
		return "info-agrupacion";
	}
	
	@GetMapping("/clasificacion")
	public String mostrarPuntosController (Model model) {
		return "clasificacion";
	}
}
