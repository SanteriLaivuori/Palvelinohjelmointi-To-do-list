package com.example.ToDoLista.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ToDoLista.domain.TaskRepository;
import com.example.ToDoLista.domain.TypeRepository;
import com.example.ToDoLista.model.Task;
	// Repositorien esittely
@Controller
public class TaskController {
	private TaskRepository taskRepository;
	private TypeRepository typeRepository;
	// Repositorien esittely
	@Autowired
	public TaskController(TaskRepository taskRepository, TypeRepository typeRepository) {
		this.taskRepository = taskRepository;
		this.typeRepository = typeRepository;
	}
	// Käyttäjän luonti-sivulle siirtyminen "localhost:8080"-osoitteesta
	@GetMapping("/")
	public String index() {
		return "redirect:tasklist";
	}
	// Kirjautumis-sivulle siirtyminen
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	// Koko tehtävälista
	@RequestMapping(value = "/tasklist", method = RequestMethod.GET)
	public String tasklist(Model model) {
		model.addAttribute("tasks", taskRepository.findAll());
		return "tasklist";
	}
	// Rest-palvelu tehtävälistalle
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public @ResponseBody List<Task> taskRest() {
		return (List<Task>) taskRepository.findAll();
	}
	// Rest-palvelu yksittäiselle tehtävälle ID:n mukaan
	@RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id") Long taskId) {
		return taskRepository.findById(taskId);
	}
	// Uuden tehtävän lisäys
	@RequestMapping(value = "/add")
	public String addTask(Model model) {
		model.addAttribute("task", new Task());
		model.addAttribute("type", typeRepository.findAll());
		return "addtask";
	}
	// Tehtävän tallennus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Task task) {
		taskRepository.save(task);
		return "redirect:/tasklist";
	}
	// Tehtävän poisto vain ADMIN-oikeuksilla
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") Long taskId, Model model) {
		taskRepository.deleteById(taskId);
		return "redirect:../tasklist";
	}
	// Tehtävän muokkaaminen
	@RequestMapping(value = "/edit/{id}")
	public String editTask(@PathVariable("id") Long taskId, Model model) {
		model.addAttribute("task", taskRepository.findById(taskId));
		model.addAttribute("type", typeRepository.findAll());
		return "edittask";
	}

}
