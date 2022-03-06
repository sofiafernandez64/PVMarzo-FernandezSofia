package ar.edu.unju.edm.controller;

import java.io.IOException;
import java.util.Base64;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.service.IPeliculaService;

@Controller
public class PeliculaController {
	
	private static final Log LOGGER = LogFactory.getLog(PeliculaController.class);

	
	@Autowired
	IPeliculaService peliculaService;
	
	
	
	@GetMapping("/pelicula/mostrar")
	public String cargarPelicula(Model model) {
	
		//model.addAttribute("unaPelicula", peliculaService.crearPelicula());
		model.addAttribute("peliculas",  peliculaService.obtenerTodasPeliculas());
		return("lista-peliculas");
		
	}
	
		@GetMapping("/peliculaadmi/mostrar")
		public String cargarPeliculaAdmi(Model model) {
		
			model.addAttribute("unaPelicula", peliculaService.crearPelicula());
			model.addAttribute("peliculas",  peliculaService.obtenerTodasPeliculas());
			return("tabla-peliculas-admi");

		}
		
		
		

@GetMapping("/pelicula/editar/{codProducto}")
public String editarPelicula(Model model, @PathVariable(name="codProducto") int codigo) throws Exception{
	try {
		//permite realizar una accion, y si ocurre error no se cae el program
		Pelicula peliculaEncontrado = peliculaService.encontrarUnaPelicula(codigo);
		model.addAttribute("unaPelicula", peliculaEncontrado);
		model.addAttribute("editMode", "true");
	}
	catch(Exception e)
	{//pasar excepcione a html
		model.addAttribute("formUsuarioErrorMessage", e.getMessage());
		model.addAttribute("unaPelicula", peliculaService.crearPelicula());
		model.addAttribute("editMode", "false");
	}
	model.addAttribute("peliculas", peliculaService.obtenerTodasPeliculas());
	return("tabla-peliculas-admi");
	
}
      
@PostMapping(value="/pelicula/guardar", consumes = "multipart/form-data")
public String guardarNuevaPelicula(@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("unaPelicula") Pelicula nuevaPelicula,BindingResult resultado, Model model) throws IOException {
	if(resultado.hasErrors()) {
		model.addAttribute("unaPelicula", nuevaPelicula);
		model.addAttribute("peliculas", peliculaService.obtenerTodasPeliculas());
	return ("tabla-peliculas-admi");
	}
	else {
	byte[] content = file.getBytes();
	String base64 = Base64.getEncoder().encodeToString(content);
	nuevaPelicula.setImagen(base64);
	peliculaService.guardarPelicula(nuevaPelicula);
	//mostrar el listado de producto luego de la carga de un producto		
	return "redirect:/peliculaadmi/mostrar";
	}
}


@PostMapping(value="/pelicula/modificar", consumes="multipart/form-data")
public String modificarPelicula(@RequestParam("file")MultipartFile file, @ModelAttribute("unaPelicula") Pelicula peliculaModificado, Model model) {
	LOGGER.info("METHOD: ingresando el metodo modificar");
	try {
		byte[] content = file.getBytes();
		String base64 = Base64.getEncoder().encodeToString(content);
          peliculaModificado.setImagen(base64);
		peliculaService.modificarPelicula(peliculaModificado);
		model.addAttribute("unaPelicula", new Pelicula());
		model.addAttribute("editMode", "false");
	}
	catch(Exception e)
	{
		model.addAttribute("formUsuarioErrorMessage", e.getMessage());
		model.addAttribute("unaPelicula", peliculaModificado);
		model.addAttribute("peliculas", peliculaService.obtenerTodasPeliculas());
		model.addAttribute("editMode","true");
	}
	model.addAttribute("peliculas", peliculaService.obtenerTodasPeliculas());
	return ("tabla-peliculas-admi");
}



   

	

		
		
	
	}
