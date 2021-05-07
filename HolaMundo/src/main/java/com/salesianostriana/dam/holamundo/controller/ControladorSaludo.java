package com.salesianostriana.dam.holamundo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorSaludo {

	@GetMapping("/saludo")
	public String saludoController (Model model){
		model.addAttribute("saludo", "Hola Mundo!!!");
		model.addAttribute("mensaje","Me llena de orgullo y satisfacción...");
		model.addAttribute("url", "https://triana.salesianos.edu");
		return "PlantillaSaludo";
	}
}
