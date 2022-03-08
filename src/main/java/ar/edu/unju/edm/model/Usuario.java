package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="USUARIOS")
@Component
public class Usuario {
	

	@Id
	@Column	
	private Integer dni;
	@NotBlank(message="Debe ingresar un apellido")
	@Size(min = 3, message = "El apellido debe tener 3 caracteres como minimo")
	@Column
	private String apellido;
	@NotBlank(message="Debe ingresar un nombre")
	@Size(min = 3, message = "El nombre debe tener 3 caracteres como minimo")
	@Column
	private String nombre;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd") //recibe la fechaNacimiento de año, mes y dia y la guarda en fechaNacimiento
	private LocalDate fechaNacimiento; //LocalDate
	@NotBlank(message="Debe ingresar una contrasenia")
	@Column
	private String password;
	@Column
	private String tipoUsuario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	

	

	public Usuario(Integer dni, @NotBlank(message = "Debe ingresar un apellido") String apellido,
			@NotBlank(message = "Debe ingresar un nombre") String nombre, LocalDate fechaNacimiento, String password,
			String tipoUsuario) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}





	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}





	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", password=" + password + ", tipoUsuario=" + tipoUsuario + "]";
	}




}
