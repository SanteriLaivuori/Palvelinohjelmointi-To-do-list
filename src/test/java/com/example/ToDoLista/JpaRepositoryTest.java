package com.example.ToDoLista;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ToDoLista.domain.TaskRepository;
import com.example.ToDoLista.domain.TypeRepository;
import com.example.ToDoLista.domain.UserRepository;
import com.example.ToDoLista.model.Task;
import com.example.ToDoLista.model.Type;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private TypeRepository typeRepository;
    
    @Autowired
    private UserRepository userRepository;
    // Tässä testissä testataan tehtävän luontia Type-"kategoriaan"
    @Test
	public void createTypeAndTask(){
		Type Uusi = new Type("Test");
		typeRepository.save(Uusi);
	
        Task task = new Task("Test", "Test", Uusi);
        taskRepository.save(task);

		assertThat(task.getId()).isNotNull();
		assertThat(task.getSubject()).isEqualTo("Test");
	}
    // Tässä testissä testataan tehtävän poistamista
    @Test
	public void deleteAndFindTask(){
        Type Uusi = new Type("Test");
        typeRepository.save(Uusi);

        Task task = new Task("Test", "Test", Uusi);
        taskRepository.save(task);
        List<Task> tasks = taskRepository.findByid((long) 0);
        taskRepository.delete(tasks.get(0));

        List<Task> tasktest = taskRepository.findByid((long) 0);

        assertThat(tasktest).hasSize(0);

    }
}
