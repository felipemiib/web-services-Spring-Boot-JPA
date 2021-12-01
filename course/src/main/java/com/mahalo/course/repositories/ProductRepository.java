package com.mahalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahalo.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
