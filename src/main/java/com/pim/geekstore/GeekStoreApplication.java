package com.pim.geekstore;

import com.pim.geekstore.models.Usuario;
import com.pim.geekstore.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeekStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeekStoreApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UsuarioRepository usuarioRepository){
		return args -> {
			if(usuarioRepository.findAll().stream().count() <= 0){
				var usuario = new Usuario();
				usuario.setUsername("supervisor");
				usuario.setPassword("supervisor");
				usuario.setAdmin(true);
				usuarioRepository.save(usuario);

				usuario = new Usuario();
				usuario.setUsername("vendas");
				usuario.setPassword("vendas");
				usuario.setAdmin(false);
				usuarioRepository.save(usuario);

				usuario = new Usuario();
				usuario.setUsername("estoque");
				usuario.setPassword("estoque");
				usuario.setAdmin(false);
				usuarioRepository.save(usuario);
			}
		};
	}

}
