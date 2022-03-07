package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.VentaTicket;


@Service
public interface IVentaTicketService {
	

	public void guardarVenta(VentaTicket unaVenta);
	public VentaTicket crearVenta();
	public List<VentaTicket> obtenerTodaVenta();
	public VentaTicket encontrarUnaVenta(int id) throws Exception;
	
	
	public List<VentaTicket> buscarPelicula(String nombrePelicula);


}
