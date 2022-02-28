package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.service.IPeliculaService;

@Controller
public class PeliculaController {
	
	private static final Log LOGGER = LogFactory.getLog(PeliculaController.class);

	
	@Autowired
	IPeliculaService peliculaService;
	
	
	@GetMapping("/pelicula/mostrar")
	public String cargarProducto(Model model) {
	
		//model.addAttribute("unaPelicula", peliculaService.crearPelicula());
		model.addAttribute("peliculas",  peliculaService.obtenerTodasPeliculas());
		return("lista-peliculas");
		
		
		

}
	}
