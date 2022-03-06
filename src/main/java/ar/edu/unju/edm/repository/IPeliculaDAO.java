package ar.edu.unju.edm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.Usuario;

@Repository
public interface IPeliculaDAO extends CrudRepository<Pelicula, Integer>{
	public Optional<Pelicula> findByCodPelicula(Integer codPelicula);



}
