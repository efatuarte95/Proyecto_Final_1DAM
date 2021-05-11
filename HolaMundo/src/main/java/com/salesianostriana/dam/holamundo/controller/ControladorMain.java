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
	
	@GetMapping("/sesion")
	public String listarAgrupacionesSesionController (Model model) {
		return "sesion";
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

	@GetMapping("/info-agrupacion")
	public String mostrarInfoAgrupacionController (Model model) {
		return "info-agrupacion";
	}
	
	@GetMapping("/clasificacion")
	public String mostrarPuntosController (Model model) {
		return "clasificacion";
	}

	@GetMapping("/radio")
	public String mostrarRadioController (Model model) {
		return "radio";
	}
}
