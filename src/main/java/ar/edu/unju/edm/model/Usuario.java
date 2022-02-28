package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="USUARIOS")
@Component
public class Usuario {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idUsuario;
	
	@Id
	@Column
	private Integer dni;
	@Column
	private String apellido;
	@Column
	private String nombre;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd") //recibe la fechaNacimiento de año, mes y dia y la guarda en fechaNacimiento
	private LocalDate fechaNacimiento; //LocalDate
	@Column
	private String password;
	@Column
	private String tipoUsuario;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, Integer dni, String apellido, String nombre, LocalDate fechaNacimiento,
			String password, String tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
		return "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", fechaNacimiento=" + fechaNacimiento + ", password=" + password + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}
	
	


}
