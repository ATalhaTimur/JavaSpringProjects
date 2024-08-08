package com.JavaProjects.SpringBoot.TodoApp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {

	private int id;
	private String Username;
	@Size(min=10,message="Enter at least 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.Username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", Username=" + Username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
