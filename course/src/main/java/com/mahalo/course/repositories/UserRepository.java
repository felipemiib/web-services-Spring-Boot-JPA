package com.mahalo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahalo.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
