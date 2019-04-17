package com.example.ToDoLista.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ToDoLista.model.Type;
	// Repositorio Typelle, joka kertoo millainen tehtävä on kyseessä (freetime, school, work)
public interface TypeRepository extends CrudRepository <Type, Long> {
	List<Type> findByName(String name);

}
