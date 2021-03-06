package ar.edu.unju.edm.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class UsuarioController {
	private static final Log LOGGER= LogFactory.getLog(UsuarioController.class);

	
	@Autowired
	IUsuarioService usuarioService; 
	
	
	
	@GetMapping("/inicio/mostrar")
	public String mostrar(){
		return "inicio-usuario";
	}
	
	@GetMapping("/inicioadmi/mostrar")
	public String mostrarAdmi() {
		return "inicio-admi";
	}
	

	@GetMapping("/usuario/crearNuevo")
	public String crearUsuarioNuevo(Model model) {
		model.addAttribute("unUsuario", usuarioService.crearUsuario());
		return "registro-usuario";
	}

	@GetMapping("/usuario/mostrar")
	public String cargarUsuarios(Model model) {
		//model.addAttribute("unUsuario", usuarioService.crearUsuario());
		model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
		return "lista-usuarios";
	}
	

	
	
	@GetMapping("/usuario/editar/{dni}")
	public String editarUsuario(Model model, @PathVariable(name="dni") int dni) throws Exception{
		try {
			//permite realizar una accion, y si ocurre error no se cae el program
			Usuario usuarioEncontrado = usuarioService.encontrarUnUsuario(dni);
			model.addAttribute("unUsuario", usuarioEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch(Exception e)
		{//pasar excepcione a html
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("unUsuario", usuarioService.crearUsuario());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
		return("usuarioedito"); //??ista-usuarios
	}

	/*
	@PostMapping("/usuario/guardar")
	public String guardarNuevoUsuario(@Valid @ModelAttribute("unUsuario") Usuario nuevoUsuario,BindingResult resultado, Model model) {
		LOGGER.info("METHOD: ingresando a Guardar");
	if (resultado.hasErrors())
	{
		model.addAttribute("unUsuario",nuevoUsuario);
		model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
	return ("lista-usuarios");
	}
	else {
	//deberia haber try
	usuarioService.guardarUsuario(nuevoUsuario);		
		LOGGER.info("Tama??o del Listado: "+usuarioService.obtenerTodosUsuarios().size());
		return "redirect:/usuario/mostrar";
	}
	
	}
	*/
	
	@PostMapping("/usuario/guardar")
	public String guardarNuevoUsuario(@Valid @ModelAttribute("unUsuario") Usuario nuevoUsuario,BindingResult resultado, Model model) {
		LOGGER.info("METHOD: ingresando a Guardar");
	if (resultado.hasErrors())
	{
		model.addAttribute("unUsuario",nuevoUsuario);
		//model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
	return ("registro-usuario");
	}
	else {
	usuarioService.guardarUsuario(nuevoUsuario);		
		return "redirect:/home";
	}
	
	}
	
	
	
	
	
	
	
	
	@PostMapping("/usuario/modificar")
	public String modificarUsuario(@ModelAttribute("unUsuario") Usuario usuarioModificado, Model model) {
	
		try {	//LOGGER.info("METHOD: ingresando el metodo modificar 1"+clienteModificado.getIdCliente());
			usuarioService.modificarUsuario(usuarioModificado);
			LOGGER.info("METHOD: ingresando el metodo modificar 2");
			model.addAttribute("unUsuario", new Usuario());
			model.addAttribute("editMode", "false");
		}
		catch(Exception e)
		{
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			model.addAttribute("unUsuario", usuarioModificado);
			model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
			model.addAttribute("editMode","true");
		}
		model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
		return ("lista-usuarios");
	}


	@GetMapping("/usuario/cancelar")
	public String cancelar() {
		return "redirect:/usuario/mostrar";
	}
	
	@GetMapping("/usuario/eliminarUsuario/{dni}")
	public String eliminarUsuario(Model model, @PathVariable(name="dni") int dni) {		
		try {		usuarioService.eliminarUsuario(dni);			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/usuario/mostrar";
	}
	

	

}