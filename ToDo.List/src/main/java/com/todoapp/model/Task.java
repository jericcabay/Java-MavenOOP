package com.todoapp.model;

import java.time.LocalDate;

public class Task {
	private int id;
	private String name;
	private String description;
	private LocalDate dueDate;
	private String priority;
	private boolean isComplete;
	
	public Task(int id, String name, String description, LocalDate dueDate, String priority) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.isComplete = false;
	}
	
	//Id
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	//Name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
	return name;
	}
	
	//Description
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	
	//Due Date
	public void setdueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	// Priority
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getPriority() {
		return priority;
	}
	
	public void setIsComplete(boolean complete) {
		isComplete = complete;
	}
	public boolean getIsComplete() {
		return isComplete;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + "\n" +
				"TaskName: " + name + "\n" +
				"Description: " + description + "\n" +
				"Priority: " + priority + "\n" +
				"Due Date: " + dueDate + "\n" +
				"Complete: " + isComplete + "\n";
	}
}
