package com.salesianostriana.dam.holamundo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String inicioController (Model model){
		return "home";
	}

	@GetMapping("/radio")
	public String mostrarRadioController (Model model) {
		return "radio";
	}
}