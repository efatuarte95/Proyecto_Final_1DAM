package com.salesianostriana.dam.pruebas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
	
	@GetMapping("/")
	public String inicioController (Model model){
		return "home";
	}

	@GetMapping("/radio")
	public String mostrarRadioController (Model model) {
		return "radio";
	}

}
