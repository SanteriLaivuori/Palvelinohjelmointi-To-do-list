package com.example.ToDoLista;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ToDoLista.domain.TaskRepository;
import com.example.ToDoLista.domain.TypeRepository;
import com.example.ToDoLista.domain.UserRepository;
import com.example.ToDoLista.model.Task;
import com.example.ToDoLista.model.Type;
import com.example.ToDoLista.model.User;

@SpringBootApplication
public class ToDoListaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListaApplication.class, args);
	}
	// Testidatan esittely commandlinerunnerin kautta
	@Bean
	public CommandLineRunner Task(TaskRepository taskRepository, TypeRepository typeRepository, UserRepository userRepository) {
		return (args) -> {
			typeRepository.save(new Type("Freetime"));
			typeRepository.save(new Type("School"));
			typeRepository.save(new Type("Work"));
	
			taskRepository.save(new Task("Read a book", "18.4.2019", typeRepository.findByName("Freetime").get(0)));
	// Testikäyttäjien luonti tietokantaan
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
		};
	}

}
