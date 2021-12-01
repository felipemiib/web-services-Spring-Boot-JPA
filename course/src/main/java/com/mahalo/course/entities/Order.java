package com.mahalo.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahalo.course.entities.enums.OrderStatus;

/*
 * Basic entity checklist:
 Basic attributes
 Associations (instantiate collections)
 Constructors
 Getters & Setters (collections: only get)
 hashCode & equals
 Serializable
 * 
 */

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	//Vinculando entidade enum na classe Order
	private Integer orderStatus;
	
	// associar muitos N (ordens) - 1 (cliente)
	// deve seguir a mesma nomenlatura no pdf Projeto-web-services-Spring-Boot-JPA
	// (Pag.2)

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		//necessário vincular o número INT do setOrderStatus no construtor
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	
	//necessário converter o atributo "orderStatus" no get/set do constructor para inteiro 
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		//validação caso o inteiro do status seja nulo
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();	
		}
		
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
