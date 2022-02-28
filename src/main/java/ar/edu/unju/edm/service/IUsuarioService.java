package ar.edu.unju.edm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;


@Service
public interface IUsuarioService {
	public void guardarUsuario(Usuario unUsuario);
	public Usuario crearUsuario();
	public List<Usuario> obtenerTodosUsuarios();
	public Usuario encontrarUnUsuario(Integer dni) throws Exception;
	public void modificarUsuario(Usuario usuarioModificado) throws Exception;
	public void eliminarUsuario(Integer dni) throws Exception;
	public Optional<Usuario> obtenerUnUsuario(Integer dni);


}
