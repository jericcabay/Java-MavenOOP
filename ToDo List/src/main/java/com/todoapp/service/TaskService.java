package com.todoapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.todoapp.model.Task;

public class TaskService {
	private List<Task> tasks = new ArrayList<>();
	private int idCounter = 1;
	
	public Task createTask(String name, String description, LocalDate dueDate, String priority) {
		Task task = new Task(idCounter++, name, description, dueDate, priority);
		tasks.add(task);
		return task;
	}
	
	public List<Task> getAllTasks() {
		return tasks;
	}

	public Task updateTask(int taskId, String name, String description, LocalDate dueDate, String priority) {
		Task task = findTaskById(taskId);
		if(task != null ) {
			task.setName(name);
			task.setDescription(description);
			task.setdueDate(dueDate);
			task.setPriority(priority);
			return task;
		}
		return null;
	}
	
	public boolean deleteTask(int taskId) {
		Task task = findTaskById(taskId);
		if(task != null) {
			tasks.remove(task);
			return true;
		}
		return false;
	}
	
	public boolean completeTask(int taskId) {
		Task task = findTaskById(taskId);
		if(task != null) {
			task.setIsComplete(true);
			return true;
		}
		return false;
	}
	
	public List<Task> getTasksByPriority(String priority) {
		return tasks.stream()
				.filter(task -> task.getPriority().trim().equalsIgnoreCase(priority.trim()))
				.collect(Collectors.toList());
	}

	
	// FIND THE TASK ID
	private Task findTaskById(int taskId) {
		// TODO Auto-generated method stub
		return tasks.stream().filter(t -> t.getId() == taskId).findFirst().orElse(null);
	}
}
