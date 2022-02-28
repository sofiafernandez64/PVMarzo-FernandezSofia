package ar.edu.unju.edm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;


@Controller
public class UsuarioController {
	
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
	
/*
	//esta es la parte de crear un nuevo usuario
	@GetMapping("/usuario/mostrar")//recibo la peticion a traves del get mapping
	public String cargarUsuario(Model model) { 
		model.addAttribute("unUsuario", usuarioService.crearUsuario());
		//model.addAttribute("turistas", turistaService.obtenerTodosTuristas());
		return "registro-usuario";
	}
	
	
	@PostMapping("/usuario/guardar")
	public String guardarNuevoUsuario(@ModelAttribute("unUsuario") Usuario nuevoUsuario, Model model) {
		usuarioService.guardarUsuario(nuevoUsuario);
		return "redirect:/home";
	}
	
	*/

	@GetMapping("/lista/mostrar")
	public String cargarListaUsuarios(Model model) {
		
		model.addAttribute("usuarios", usuarioService.obtenerTodosUsuarios());
		return "lista-usuarios";
	}
	
	@PostMapping("/save")
	public String guardar (Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/lista/mostrar";
	}
	
	@GetMapping("/editar/{dni}")
	public String editar(@PathVariable Integer dni, Model model) {
		Optional<Usuario> usuario = usuarioService.obtenerUnUsuario(dni);
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminar(@PathVariable Integer dni, Model model) throws Exception {
		usuarioService.eliminarUsuario(dni);
		return "redirect:/lista/mostrar";
	}

	

}
