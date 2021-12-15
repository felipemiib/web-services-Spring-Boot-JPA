package com.mahalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahalo.course.entities.OrderItem;
import com.mahalo.course.entities.pk.OrderItemPK;

//deve inserir a entidade OrderItem com base no Id informado na entidade OrderItem (Embedded)
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
