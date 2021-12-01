package com.mahalo.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahalo.course.entities.Category;
import com.mahalo.course.services.CategoryService;

@RestController // informa que é gerenciado por um controlador
@RequestMapping(value = "/categories") //indica qual dado o controlador vai seguir || API localhost:8080/users
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping //ENDPOINT: coletar ID : http://localhost:8080/users || FIND ALL
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // indica qual dado o controlador vai seguir || API localhost:8080/users/id
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}

}