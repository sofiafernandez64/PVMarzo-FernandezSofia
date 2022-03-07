package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.VentaTicket;

@Repository
public interface IVentaTicketDAO extends CrudRepository<VentaTicket, Integer>{
	
	/*
	public List<VentaTicket> findByPeliculaNombre(String nombrePelicula);
*/

}
