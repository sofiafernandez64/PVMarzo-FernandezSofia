package ar.edu.unju.edm.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioDAO;
import ar.edu.unju.edm.service.IUsuarioService;

@Service
public class UsuarioServiceImpMySQL implements IUsuarioService{

	@Autowired
	Usuario unUsuario;
	
	@Autowired
	IUsuarioDAO usuarioDAO;
	
	
	@Override
	public void guardarUsuario(Usuario unUsuario) {
		// TODO Auto-generated method stub
		String pw = unUsuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setPassword(bCryptPasswordEncoder.encode(pw));
		usuarioDAO.save(unUsuario);
		
	}

	@Override
	public Usuario crearUsuario() {
		// TODO Auto-generated method stub
		return unUsuario;
	}

	@Override
	public List<Usuario> obtenerTodosUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	public Usuario encontrarUnUsuario(Integer dni) throws Exception {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(dni).orElseThrow(()->new Exception("El usuario no existe"));

		
	}

	@Override
	public void modificarUsuario(Usuario usuarioModificado) throws Exception {
		// TODO Auto-generated method stub
		
		
		Usuario usuarioAModificar = usuarioDAO.findByDni(usuarioModificado.getDni()).orElseThrow(()->new Exception("El Usuario no fue encontrado"));
		
		cambiarUsuario(usuarioModificado, usuarioAModificar);
		
		usuarioDAO.save(usuarioAModificar);

}

    private void cambiarUsuario(Usuario desde, Usuario hacia) {
    	hacia.setApellido(desde.getApellido());
    	hacia.setDni(desde.getDni()); //este que no lo cambie
    	hacia.setFechaNacimiento(desde.getFechaNacimiento());
    	hacia.setNombre(desde.getNombre());
    	hacia.setPassword(desde.getPassword());
    	hacia.setTipoUsuario(desde.getTipoUsuario());
   
}

	

	@Override
	public void eliminarUsuario(Integer dni) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioAEliminar = usuarioDAO.findById(dni).orElseThrow(()->new Exception("El usuario no fue encontrado"));

		usuarioDAO.delete(usuarioAEliminar);

		
		

		
	}

	@Override
	public Optional<Usuario> obtenerUnUsuario(Integer dni) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = usuarioDAO.findByDni(dni);
		return usuario;
	}

}
