package com.mahalo.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahalo.course.entities.User;

@RestController // informa que é gerenciado por um controlador
@RequestMapping(value = "/users") //indica qual dado o controlador vai seguir
public class UserResource {

	@GetMapping //coletar ID : http://localhost:8080/users
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}