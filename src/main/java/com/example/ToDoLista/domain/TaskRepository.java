package com.example.ToDoLista.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ToDoLista.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	List<Task> findByid(Long id);

}