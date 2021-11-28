package com.mahalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahalo.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
