package ar.edu.unju.edm.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
	private int dni;
	private String apellido;
	private String nombre;
	@DateTimeFormat(pattern = "yyyy-MM-dd") //recibe la fechaNacimiento de año, mes y dia y la guarda en fechaNacimiento
	private LocalDate fechaNacimiento; //LocalDate
	private String password;
	private String tipoUsuario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Usuario(int dni, String apellido, String nombre, LocalDate fechaNacimiento, String password,
			String tipoUsuario) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}



	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
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
