package com.jacaranda.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Calculator;

@Controller
public class ControladorPrincipal {

	@GetMapping("/")
	public String principal() {
		return "index";
	}
	
	@GetMapping("/bienvenido") 
		public String welcome(Model model,
							@RequestParam Optional<String> nombreSaludo,
							@RequestParam(required=false, defaultValue="Nieve") String apellido ) {
			model.addAttribute("Mensaje",nombreSaludo);
			model.addAttribute("Apellido",apellido);

			/*-Esto es el HTML que devuelve la URL-*/
			return "index";
	}
	
	@GetMapping("/calculadora")
		public String suma(Model model) {
			Calculator calc = new Calculator();
			
			model.addAttribute("calc", calc);

			/*-Esto es el HTML que devuelve la URL-*/
			return("calculadora");
		}
	
	@PostMapping("/calculadora/submit")
	public String sumaSubmit(Model model,
		@ModelAttribute("calc") Calculator calculadora ) {
		
		model.addAttribute("resultado", calculadora.operar());
		
		/*-Esto es el HTML que devuelve la URL-*/
		return("resultado");
	}
	
}
