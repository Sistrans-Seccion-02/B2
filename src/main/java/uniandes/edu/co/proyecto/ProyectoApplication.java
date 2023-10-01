package uniandes.edu.co.proyecto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uniandes.edu.co.proyecto.Modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

	@Override
	public void run (String... arg)
	{
		Collection<Usuario> usuarios= usuarioRepository.darUsuarios();
		
		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

}
