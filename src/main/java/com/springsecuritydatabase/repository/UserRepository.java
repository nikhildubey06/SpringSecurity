package com.springsecuritydatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecuritydatabase.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
