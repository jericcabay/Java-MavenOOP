package com.todoapp.manager;

import com.todoapp.model.Task;
import com.todoapp.service.TaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class TaskManager {

	private static final Task Task = null;
	private TaskService taskService;
	private Scanner scanner;
	
	public TaskManager () {
		this.taskService = new TaskService();
		this.scanner = new Scanner(System.in);
	}
	
	public void MenuTask() {
		while(true) {
			System.out.println("\nTo Do List application");
			System.out.println("1. Create Task");
			System.out.println("2. View All Task");
			System.out.println("3. Update Task");
			System.out.println("4. Complete Task");
			System.out.println("5. Delete Task");
			System.out.println("6. Filter Tasks by priority");
			System.out.println("Exit");
			
			System.out.print("Choose an options: ");
			int pickOne = scanner.nextInt();
			
			switch(pickOne) {
			case 1:
				createTask();
				break;
			case 2:
				ViewTask();
				break;
			case 3:
				updateTask();
				break;
			case 4:
				completeTask();
				break;
			case 5:
				deleteTask();
				break;
			case 6:
				filteredTaskPriority();
				break;
			case 7:
				System.out.println("Good Bye...");
				scanner.close();
				return;
			default:
				System.out.println("Please Enter a valid Choice");
			}
			
		}
		
	}
	
	private void createTask() {
		System.out.print("Enter Task Name: ");
		String name = scanner.nextLine();
		scanner.nextLine();
		System.out.print("Enter a description: ");
		String description = scanner.nextLine();
		
		System.out.print("Enter due date (YYYY-MM-DD): ");
		String DueDateStr = scanner.nextLine();
		LocalDate dueDate = LocalDate.parse(DueDateStr);
		
		System.out.print("Enter task priority (Low, Medium, Large): ");
		String priority = scanner.nextLine();
		taskService.createTask(name, description, dueDate, priority);
		
	}
	
	private void ViewTask() {
		List<Task> task = taskService.getAllTasks();
		task.forEach(System.out::println);
	}

	private void updateTask() {
		// TODO Auto-generated method stub
		System.out.println("Enter Id task to Update: ");
		int updateId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Update Task Name: ");
		String updateName = scanner.nextLine();
		
		System.out.print("Update description: ");
		String updateDescription = scanner.nextLine();
		
		System.out.print("Update the Due Date (YYYY-MM-DD): ");
		String DueDateStr = scanner.nextLine();
		LocalDate updateDueDate = LocalDate.parse(DueDateStr);
		
		System.out.print("Update priority (Low, Medium, Large): ");
		String updatePriority = scanner.nextLine();
		
		Task UpdatedTask = taskService.updateTask(updateId, updateName, updateDescription, updateDueDate, updatePriority);
		
		if(UpdatedTask != null) {
			System.out.println("Successfully UpdateTask");
		} else {
			System.out.println("Failed to Update");
		}	
	}
	
	public void completeTask() {
		System.out.println("Enter Task ID to mark complete: ");
		int completeTask = scanner.nextInt();
		if(taskService.completeTask(completeTask)) {
			System.out.println("Complete Task.");
		} else {
			System.out.println("Failed to complete");
		}
	}
	
	public void deleteTask() {
		System.out.print("Enter Task ID to Delete: ");
		int deletedTask = scanner.nextInt();
		scanner.nextLine();
		if(taskService.deleteTask(deletedTask)) {
			System.out.println("Complete Delete the task");
		} else {
			System.out.println("Failed to Delete");
		}
	}
	
	public void filteredTaskPriority() {
		System.out.print("Enter priority to filter by (Low, Medium, High): ");
		String filterPriority = scanner.nextLine().trim();
		scanner.nextLine();
		
		List<Task> priorityTask = taskService.getTasksByPriority(filterPriority);
		if(priorityTask.isEmpty()) {
			System.out.println("No Task Found with the given priority");
		}
			priorityTask.forEach(System.out::println);
	}
}
