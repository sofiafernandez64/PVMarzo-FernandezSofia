package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.repository.IPeliculaDAO;
import ar.edu.unju.edm.service.IPeliculaService;

@Service
public class PeliculaServiceImpMySQL implements IPeliculaService{

	@Autowired 
	Pelicula unaPelicula;

	@Autowired
	IPeliculaDAO peliculaDAO;
	
	@Override
	public void guardarPelicula(Pelicula unaPelicula) {
		// TODO Auto-generated method stub
		peliculaDAO.save(unaPelicula);
		
	}

	@Override
	public Pelicula obtenerPeliculaCodigo(Integer codPelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula crearPelicula() {
		// TODO Auto-generated method stub
		return unaPelicula;
	}

	@Override
	public void modificarPelicula(Pelicula peliculaModificado) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPelicula(Integer codPelicula) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pelicula obtenerPelicula(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> obtenerTodasPeliculas() {
		// TODO Auto-generated method stub
		return (List<Pelicula>) peliculaDAO.findAll();

	}

	@Override
	public Pelicula obtenerPeliculaNuevo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula encontrarUnaPelicula(Integer codPelicula) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
