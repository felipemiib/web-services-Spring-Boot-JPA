package com.mahalo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahalo.course.entities.Category;
import com.mahalo.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired //injeção de dependência com a instância
	private CategoryRepository repository;
	//METODO FIND ALL
	public List<Category> findAll() {
		return repository.findAll();
	}
	//METODO FIND BY ID
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
