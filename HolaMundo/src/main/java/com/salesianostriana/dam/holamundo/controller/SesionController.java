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

	@GetMapping("/sesion")
	public String listarAgrupacionesSesionController (Model model) {
List<Agrupacion> lista = new ArrayList<Agrupacion>();
		
		lista.add(new Agrupacion("La Chusma Selecta", "Antonio Martínez Ares", "Cádiz", "Comparsa"));
		lista.add(new Agrupacion("Los Cadizfornia", "Jose Antonio Vera Luque", "Cádiz", "Chirigota"));
		lista.add(new Agrupacion("La Colonial", "David Fernández", "Cádiz", "Coro"));
		lista.add(new Agrupacion("El Cuarteto del More", "Iván Romero", "Cádiz", "Cuarteto"));
		lista.add(new Agrupacion("Chernobyl, el musical", "'Canijo' de Sevilla", "Sevilla", "Chirigota"));
		lista.add(new Agrupacion("Oh Capitán my Capitán", "Tino Tovar", "Cádiz", "Comparsa"));
		lista.add(new Agrupacion("Equipo A minúscula", "El Morera", "Cádiz", "Cuarteto"));
		lista.add(new Agrupacion("Los Superhombres", "Rafael Martin", "Sevilla", "Coro"));
				
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
