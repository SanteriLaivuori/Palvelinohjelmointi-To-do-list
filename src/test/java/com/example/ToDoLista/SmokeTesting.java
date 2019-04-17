package com.example.ToDoLista;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ToDoLista.web.TaskController;
import com.example.ToDoLista.web.UserController;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class SmokeTesting {
		@Autowired
		private TaskController taskcontroller;

		@Autowired
		private UserController usercontroller;

		@Test
		public void contextLoads() throws Exception {
			assertThat(taskcontroller).isNotNull();
			assertThat(usercontroller).isNotNull();
		}
	}
