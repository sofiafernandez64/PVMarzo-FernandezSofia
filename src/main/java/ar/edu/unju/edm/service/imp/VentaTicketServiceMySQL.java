package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.VentaTicket;
import ar.edu.unju.edm.repository.IVentaTicketDAO;
import ar.edu.unju.edm.service.IVentaTicketService;

@Service
public class VentaTicketServiceMySQL implements IVentaTicketService{

	@Autowired
	VentaTicket venta;
	
	@Autowired
	IVentaTicketDAO ventaDAO;
	
	@Override
	public void guardarVenta(VentaTicket unaVenta) {
		// TODO Auto-generated method stub
		ventaDAO.save(unaVenta);
		
	}

	@Override
	public VentaTicket crearVenta() {
		// TODO Auto-generated method stub
		return venta;
	}

	@Override
	public List<VentaTicket> obtenerTodaVenta() {
		// TODO Auto-generated method stub
		return (List<VentaTicket>) ventaDAO.findAll();
	}
	

	@Override
	public VentaTicket encontrarUnaVenta(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaTicket> buscarPelicula(String nombrePelicula) {
		// TODO Auto-generated method stub
		return null;
	}

}
