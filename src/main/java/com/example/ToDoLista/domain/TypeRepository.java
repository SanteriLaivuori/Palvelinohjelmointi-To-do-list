package com.example.ToDoLista.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ToDoLista.model.Type;

public interface TypeRepository extends CrudRepository <Type, Long> {
	List<Type> findByName(String name);

}
