package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.VentaTicket;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.service.IVentaTicketService;

@Controller
public class VentaTicketController {
	@Autowired
	IPeliculaService peliculaService;

	@Autowired
	IVentaTicketService ventasTicketService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	Pelicula peliculaSeleccionado;
	
	@GetMapping("/pelicula/ventas")
	public String mostrarPeliculasVentas(Model model) {
		model.addAttribute("peliculas", peliculaService.obtenerTodasPeliculas());
		return("peliculas-cartelera");
	}
	
	
	@GetMapping("/pelicula/vender/{codPelicula}")	
	public String realizarVentaTicket(Model model, @PathVariable(name="codPelicula") Integer codPelicula) throws Exception {
		VentaTicket venta = new VentaTicket();		
		try {	
			peliculaSeleccionado = peliculaService.obtenerPeliculaCodigo(codPelicula);		
			venta = ventasTicketService.crearVenta();
			venta.setPelicula(peliculaSeleccionado);
			model.addAttribute("venta",venta); //la variable venta se pasa al model con el nombre "venta"
			model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());		
		}		
		return "modal-ventaticket";
	}
	
	@PostMapping("/pelicula/vender")
	public String guardarNuevaVenta(@ModelAttribute("venta") VentaTicket unaVenta, Model model) {
		ventasTicketService.guardarVenta(unaVenta);
		return "redirect:/pelicula/ventas";
		
	}
	
	
	
}
