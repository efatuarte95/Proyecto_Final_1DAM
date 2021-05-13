package com.salesianostriana.dam.holamundo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.holamundo.model.Agrupacion;
import com.salesianostriana.dam.holamundo.servicio.AgrupacionService;

@Controller
public class AgrupacionController {

	private AgrupacionService agrupacionServicio;
	
	@GetMapping("/agrupacion")
	public String mostrarAgrupaciones(Model model) {
		model.addAttribute("agrupaciones", agrupacionServicio.findAll());
		return "agrupacion";
	}
	
	@GetMapping("/list-agrupacion")
	public String listarAgrupacionesController (Model model) {
		model.addAttribute("agrupaciones", agrupacionServicio.findAll());
		return "list-agrupacion";
	}
	
	@GetMapping("/form-agrupacion")
	public String showAgrupacionFormController (Model model) {
		Agrupacion agrupacion = new Agrupacion(); 		
		model.addAttribute("agrupacionForm", agrupacion);
		return "form-agrupacion";
	}
	
	@PostMapping ("/addAgrupacion")
	public String submit(@ModelAttribute("agrupacionForm") Agrupacion agrupacion,  Model model) {

		//Se añade al modelo la agrupacion que se creará al recoger los datos del formulario
		model.addAttribute("agrupacion", agrupacion);
		//Se muestra la página con la información mandada en el formulario al guardar 
		return "redirect:/sesion";
	}

	@GetMapping("/info-agrupacion")
	public String mostrarInfoAgrupacionController (Model model) {
		return "info-agrupacion";
	}
	
	@GetMapping("/clasificacion")
	public String mostrarPuntosController (Model model) {
		model.addAttribute("agrupaciones", agrupacionServicio.findAll());
		return "clasificacion";
	}
}
