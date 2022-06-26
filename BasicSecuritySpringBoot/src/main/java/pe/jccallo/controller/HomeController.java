package pe.jccallo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contenido")
public class HomeController {
	@GetMapping
	public String mostrar() {
		return "Bienvenido";
	}
}
