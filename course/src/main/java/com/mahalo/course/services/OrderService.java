package com.mahalo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahalo.course.entities.Order;
import com.mahalo.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired //injeção de dependência com a instância
	private OrderRepository repository;
	//METODO FIND ALL
	public List<Order> findAll() {
		return repository.findAll();
	}
	//METODO FIND BY ID
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
