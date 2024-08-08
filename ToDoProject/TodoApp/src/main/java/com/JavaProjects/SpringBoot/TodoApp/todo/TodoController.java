package com.JavaProjects.SpringBoot.TodoApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.JavaProjects.SpringBoot.TodoApp.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name") // details stored across multiple requests
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("in28minutes");
		model.addAttribute("todos", todos);
		return "listTodos";
	}

//Get, post
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String AddNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.get("name");
		todoService.AddTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	@RequestMapping("delete-todo")
	public String DeleteTodo(@RequestParam int id) {
		todoService.DeleteByID(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodo(@RequestParam int id,ModelMap model) {
		Todo todo =todoService.findByID(id);
		model.addAttribute("todo", todo);
		return "todo";
	}
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String UpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
