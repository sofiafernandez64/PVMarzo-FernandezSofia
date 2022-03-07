package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	
	@GetMapping("/consultar/ticket")
	public String consultaUsuarios(Model model) {
		model.addAttribute("buscarnombrepelicula","");
		model.addAttribute("ventasticket", ventasTicketService.obtenerTodaVenta());
		return "ventas-por-pelicula";
	}
	
	
	
	@GetMapping("/compra/buscar/")
	public String getBuscarUsuarios(Model model,@RequestParam(name = "buscarnombrepelicula")String nombreb) {
		
		model.addAttribute("buscarnombrepelicula",nombreb);
		model.addAttribute("compras", ventasTicketService.obtenerTodaVenta());
		//model.addAttribute("compras",compraService.buscarCompra(nombreb));
		return "ventas-por-pelicula";
	}
	
	/*
	@GetMapping("/consultar/pelicula")
	public String consultaPelicula(Model model) {
		model.addAttribute("todaspeliculas", peliculaService.obtenerTodasPeliculas());
		return "ventas-por-pelicula";
	}
	*/
	
	@GetMapping("/compra/listado/")
	public ModelAndView getComprasPage() {
		ModelAndView modelView = new ModelAndView("ventas-por-pelicula");
		//modelView.addObject("buscarnombrepelicula","");
		modelView.addObject("compras",ventasTicketService.obtenerTodaVenta());
		return modelView;
	}
	
	/*
	
	@PostMapping("/consultar/ticketpost")
	public String consultarPost(Model model) {
		
		return "redirect:/consultar/ticket";
	}
	
	*/
	/*
	@PostMapping("/pelicula/buscar")
	public String buscarPelicula(@ModelAttribute("unaPelicua") Pelicula peliculaEncontrado, Model model) {
		peliculaService.encontrarUnaPelicula(peliculaEncontrado);
		model.addAttribute("ventasticket", ventasTicketService.obtenerTodaVenta());

		return"resultado";
	}*/
	
	/*
	@PostMapping("/producto/guardar")//interactuo con la interfaz, le cargo datos, y luego de mostrar ocuurre algo, por eso es post Mapping//el @ModelAttibute esta diciendo que esta viniendo un atributo desde el modelo, el atributo se llama unProducto de tipo Producto y a partir de ahora se llama nuevoProducto
	public String guardarNuevoProducto(@ModelAttribute("unProducto") Producto nuevoProducto, Model model) {
		aqui tengo que buscar
		iProductoService.guardarProducto(nuevoProducto);
		//syso es una linea de control, para ver que se guardó bien
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca()); //en la posicion 0 (esta el producto), getMarca para obtener la marca
		//obtenerTodosProductos lo mando a traves del model con el nombre de "productos".
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());//
		SOFIA.error("solo de prueba"); //MENSAJES EN ROJO
		return "resultado"; //DEVUELVE UNA PAGINA
	}
	*/
	
	
	
}
