package com.salesianostriana.dam.holamundo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorMain {

	@GetMapping("/")
	public String inicioController (Model model){
		return "home";
	}
	
	@GetMapping("/list-sesion")
	public String listarSesionController (Model model) {
		return "list-sesion";
	}
	
	@GetMapping("/agrupacion")
	public String agrupacionController (Model model) {
		return "agrupacion";
	}
	
	@GetMapping("/list-agrupacion")
	public String listarAgrupacionesController (Model model) {
		return "list-agrupacion";
	}
}
