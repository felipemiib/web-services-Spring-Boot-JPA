package com.mahalo.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mahalo.course.entities.Category;
import com.mahalo.course.entities.Order;
import com.mahalo.course.entities.Product;
import com.mahalo.course.entities.User;
import com.mahalo.course.entities.enums.OrderStatus;
import com.mahalo.course.repositories.CategoryRepository;
import com.mahalo.course.repositories.OrderRepository;
import com.mahalo.course.repositories.ProductRepository;
import com.mahalo.course.repositories.UserRepository;

//configurando perfil de teste SEED
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

//popular o banco de dados com alguns objetos. Para isso, deve usar a classe repository
	@Autowired // cria a denpendencia entre o repositorio e associa ao user repository para
				// criar uma instancia
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override // tudo que for inserido nesse metodo será executado quando a aplicação para
				// ação no banco de dados
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERED ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, u1);
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //comando para salvar os objetos na tabela do banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

}
