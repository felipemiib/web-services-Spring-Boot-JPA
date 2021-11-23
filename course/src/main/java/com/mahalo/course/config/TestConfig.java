package com.mahalo.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mahalo.course.entities.User;
import com.mahalo.course.repositories.UserRepository;

//configurando perfil de teste
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

//popular o banco de dados com alguns objetos. Para isso, deve usar a classe repository
	@Autowired // cria a denpendencia entre o repositorio e associa ao user repository para
				// criar uma instancia
	private UserRepository userRepository;

	@Override // tudo que for inserido nesse metodo será executado quando a aplicação para
				// ação no banco de dados
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //comando para salvar os objetos na tabela do banco de dados

	}

}
