package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
	
	@GetMapping("/inicio/mostrar")
	public String mostrar(){
		return "inicio-usuario";
	}
	
	@GetMapping("/inicioadmi/mostrar")
	public String mostrarAdmi() {
		return "inicio-admi";
	}
	

}
