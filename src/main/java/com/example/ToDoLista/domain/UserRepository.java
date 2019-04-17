package com.example.ToDoLista.domain;



import org.springframework.data.repository.CrudRepository;

import com.example.ToDoLista.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}