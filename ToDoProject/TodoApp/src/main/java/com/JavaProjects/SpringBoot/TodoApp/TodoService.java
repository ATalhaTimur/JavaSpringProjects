package com.JavaProjects.SpringBoot.TodoApp;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.JavaProjects.SpringBoot.TodoApp.todo.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0;
	static {

		todos.add(new Todo(++todosCount, "in28minutes", "Get AWS Certified", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn Devops", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "in28minutes", "learn Full Stack Development", LocalDate.now().plusYears(3),
				false));

	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
		return todos.stream().filter(predicate).toList();
	}

	public void AddTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public void DeleteByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		DeleteByID(todo.getId());
		todos.add(todo);
	}
}
