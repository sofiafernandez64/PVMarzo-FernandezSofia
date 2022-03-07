package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;


@Service
public interface IPeliculaService {
	
	public void guardarPelicula(Pelicula unaPelicula);
	public Pelicula obtenerPeliculaCodigo(Integer codPelicula);
	public Pelicula crearPelicula();
	public void modificarPelicula(Pelicula peliculaModificado) throws Exception;
	//public void eliminarPelicula(int id) throws Exception;
	public Pelicula obtenerPelicula(String nombrePelicula);
	public List<Pelicula> obtenerTodasPeliculas();
	public Pelicula obtenerPeliculaNuevo();
	public Pelicula encontrarUnaPelicula(Integer codPelicula) throws Exception;

	public void eliminarPelicula(Integer codPelicula);

}
