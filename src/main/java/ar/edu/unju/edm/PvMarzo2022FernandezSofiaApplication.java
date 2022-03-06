package ar.edu.unju.edm;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.service.IPeliculaService;
import ar.edu.unju.edm.service.IUsuarioService;

@SpringBootApplication
public class PvMarzo2022FernandezSofiaApplication implements CommandLineRunner{

	@Autowired
	Pelicula pelicula;
	
	@Autowired
	IPeliculaService peliculaService;
	
	@Autowired
	Usuario usuario;
	
	@Autowired 
	IUsuarioService usuarioService;
	
	public static void main(String[] args){
		SpringApplication.run(PvMarzo2022FernandezSofiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Pelicula peli= new Pelicula();
		peli.setNombrePelicula("LICORICE PIZZA");
		peli.setActor("Bradley Cooper");
		peli.setCodPelicula(340);
		peli.setDescripcion("Licorice Pizza” es la historia de Alana Kane y Gary Valentine, la vida de dos jóvenes que se enamoran en el Valle de San Fernando en 1973.");
		peli.setDirector("Paul Thomas Anderson");
		peli.setDuracion(3);
		peli.setImagen("img");
		peliculaService.guardarPelicula(peli);
		
		
		Pelicula peli2= new Pelicula();
		peli2.setNombrePelicula("EL CALLEJON DE LAS ALMAS PERDIDAS");
		peli2.setActor("Cate Blanchett");
		peli2.setCodPelicula(450);
		peli2.setDescripcion("Un buscavidas (Bradley Cooper) se compincha con una pitonisa (Cate Blanchett) para estafar a millonarios...");
		peli2.setDirector("Guillermo del Toro");
		peli2.setDuracion(98);
		peli2.setImagen("img2");
		peliculaService.guardarPelicula(peli2);
		
		
		Pelicula peli3= new Pelicula();
		peli3.setNombrePelicula("CASATE CONMIGO");
		peli3.setActor("Jennifer Lopez");
		peli3.setCodPelicula(567);
		peli3.setDescripcion("Una estrella del pop es abandonada por su prometido, una estrella del rock, momentos antes de su boda en el Madison Square Garden");
		peli3.setDirector("Kat Coiro");
		peli3.setDuracion(67);
		peli3.setImagen("img3");
		peliculaService.guardarPelicula(peli3);
		
		
		Usuario usuAdmi = new Usuario();
		usuAdmi.setApellido("Torres");
		usuAdmi.setNombre("Franco");
		usuAdmi.setDni(44789644);
		usuAdmi.setFechaNacimiento(LocalDate.now());
		usuAdmi.setPassword("hola");
		usuAdmi.setTipoUsuario("Admin");
		usuarioService.guardarUsuario(usuAdmi);
		
		
		Usuario cliente = new Usuario();
		cliente.setApellido("Lopez");
		cliente.setNombre("Candela");
		cliente.setDni(23478769);
		cliente.setFechaNacimiento(LocalDate.of(1999, 10, 12)); //localDate: anio, mes y dia
		cliente.setPassword("contra");
		cliente.setTipoUsuario("Cliente");
		usuarioService.guardarUsuario(cliente);

		
		Usuario cliente2 = new Usuario();
		cliente2.setApellido("Carrizo");
		cliente2.setNombre("Tomas");
		cliente2.setDni(17234789);
		cliente2.setFechaNacimiento(LocalDate.of(1959, 8, 13));
		cliente2.setPassword("tom");
		cliente2.setTipoUsuario("Cliente");
		usuarioService.guardarUsuario(cliente2);

		
	}
	
	
	

	
	
	
	
}
