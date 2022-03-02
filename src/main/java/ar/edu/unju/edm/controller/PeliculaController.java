package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.Usuario;
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
		
		
		@GetMapping("/tablapeliculas/mostrar")
		public String cargarTablaPeliculas(Model model) {
		
			//model.addAttribute("unaPelicula", peliculaService.crearPelicula());
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
				model.addAttribute("unUsuario", peliculaService.crearPelicula());
				model.addAttribute("editMode", "false");
			}
			model.addAttribute("usuarios", peliculaService.obtenerTodasPeliculas());
			return("pelicula-edito"); 
		}
		

		
		@PostMapping("/pelicula/modificar")
		public String modificarPelicula(@ModelAttribute("unaPelicula") Pelicula peliculaModificado, Model model) {
		
			try {	//LOGGER.info("METHOD: ingresando el metodo modificar 1"+clienteModificado.getIdCliente());
				peliculaService.modificarPelicula(peliculaModificado);
				model.addAttribute("unUsuario", new Pelicula());
				model.addAttribute("editMode", "false");
			}
			catch(Exception e)
			{
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("unUsuario", peliculaModificado);
				model.addAttribute("usuarios", peliculaService.obtenerTodasPeliculas());
				model.addAttribute("editMode","true");
			}
			model.addAttribute("usuarios", peliculaService.obtenerTodasPeliculas());
			return ("tabla-peliculas-admi");
		}


		@GetMapping("/pelicula/cancelar")
		public String cancelar() {
			return "redirect:/tablapeliculas/mostrar";
		}
		
		//modal peticiones
		@GetMapping("/usuario/eliminarUsuario/{codPelicula}")
		public String eliminarCliente(Model model, @PathVariable(name="codProducto") int codigo) {		
			try {		peliculaService.eliminarPelicula(codigo);		
			}
			catch(Exception e){
				model.addAttribute("listErrorMessage",e.getMessage());
			}			
			return "redirect:/tablapeliculas/mostrar";
		}
		
		
	}
