package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PELICULAS")
@Component
public class Pelicula {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idPelicula;
	
	@Id
	@Column
	private Integer codPelicula;
	@Column
	private String nombrePelicula;
	@Column
	private String descripcion;
	@Column
	private String imagen;
	@Column
	private double duracion;
	@Column
	private String actor;
	@Column
	private String director;
	
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	
	public Pelicula(Integer idPelicula, Integer codPelicula, String nombrePelicula, String descripcion, String imagen,
			double duracion, String actor, String director) {
		super();
		this.idPelicula = idPelicula;
		this.codPelicula = codPelicula;
		this.nombrePelicula = nombrePelicula;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.duracion = duracion;
		this.actor = actor;
		this.director = director;
	}


	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Integer getCodPelicula() {
		return codPelicula;
	}

	public void setCodPelicula(Integer codPelicula) {
		this.codPelicula = codPelicula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}


	public String getNombrePelicula() {
		return nombrePelicula;
	}


	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	
	
	

}
