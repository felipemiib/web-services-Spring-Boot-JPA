package com.mahalo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahalo.course.entities.Product;
import com.mahalo.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired //injeção de dependência com a instância
	private ProductRepository repository;
	//METODO FIND ALL
	public List<Product> findAll() {
		return repository.findAll();
	}
	//METODO FIND BY ID
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
