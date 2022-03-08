package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PELICULAS")
@Component
public class Pelicula {
	
	
	
	@Id
	@Column
	@Min(value=1, message = "El codigo de la pelicula debe ser superior a 1")
	private Integer codPelicula;
	@NotBlank(message="Es obligatorio introducir un nombre de pelicula")
	@Size(min = 3, message = "El nombre de pelicula debe tener como mínimo 3 caracteres")
	@Column
	private String nombrePelicula;
	@Column
	@NotBlank(message="Es obligatorio introducir una descripcion para la pelicula")
	private String descripcion;
	@Lob
	@Column(name = "prod_imagen", columnDefinition = "LONGBLOB")
	private String imagen;
	@Column
	private double duracion;
	@NotBlank(message="Debe ingresar un nombre de actor")
	@Column
	private String actor;
	@NotBlank(message="Debe ingresar el nombre del director")
	@Column
	private String director;
	
	//@OneToMany(cascade= CascadeType.ALL)
	//List<VentaTicket>ventas; //si la consulta viene por pelicula
	
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	
	
	


	
	public Pelicula(Integer codPelicula,
			@NotBlank(message = "Es obligatorio introducir un nombre de pelicula") String nombrePelicula,
			String descripcion, String imagen, double duracion,
			@NotBlank(message = "Debe ingresar un nombre de actor") String actor,
			@NotBlank(message = "Debe ingresar el nombre del director") String director) {
		super();
		this.codPelicula = codPelicula;
		this.nombrePelicula = nombrePelicula;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.duracion = duracion;
		this.actor = actor;
		this.director = director;
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
