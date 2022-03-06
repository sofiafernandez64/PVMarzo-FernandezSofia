package ar.edu.unju.edm.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity //entity para crear la relacion y guardar en la bd
@Table(name="ventas") //@table para decirle que lo guarde con un nombre especial
public class VentaTicket { //ESTA CLASE ESTA HACIENDO LA VINCULACION ENTRE PELICULA Y USUARIO
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idVenta; //campo identificatorio

	
	@ManyToOne
	@JoinColumn(name = "dni") //estamos transformando nuestra clase venta en el contenedor de la relacion de usuario y pelicula, entre usuario y pelicula esta esta clase
	private Usuario usuario;
	
	@ManyToOne //muchos tickets pueden venderse a un usuario, y un usuario puede estar en muchas ventas de tickets
	@JoinColumn(name = "codPelicula") //conla anotacion joincolumn va a crear una columna, no guarda la pelicula
	private Pelicula pelicula; //NUESTRA venta se relaciona con dos objetos que nosotros ya tenemos en nuestra tabla

	
	
	
	@Column
	private int cantidadTickets;
	
	
	
	public VentaTicket() {
		// TODO Auto-generated constructor stub
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public int getCantidadTickets() {
		return cantidadTickets;
	}

	public void setCantidadTickets(int cantidadTickets) {
		this.cantidadTickets = cantidadTickets;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	
	
	

}
