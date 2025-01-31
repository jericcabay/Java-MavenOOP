package management.system;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;

public class BankManagement {
	private static final String ADMIN_PASSWORD = "admin1234"; // Set Your admin password 
	private static HashMap<String, BankAccount> accounts = new HashMap<>();
	private static HashSet<String> accountNumbers = new HashSet<>();
	private static HashSet<String> authorizedAdmins = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		
		//Load accounts from file
		accounts = FileHandler.loadAccounToFromFile();
		
			
			System.out.println("Welcome To Bank Account Management System");
			System.out.print("Are  you admin (1) or (2) users: ");
			int role = scanner.nextInt();
			scanner.nextLine();
			
			if(role == 1) {
				authorizedAdmins = FileHandler.loadAccount();
				Admin admin = new Admin(accounts, accountNumbers, authorizedAdmins);
				admin.adminMenu(scanner);
			} else if(role == 2) {
				User user = new User(accounts);
				user.userMenu(scanner);
			} else {
				System.out.println("Invalid role selected. Exiting...");
			}
			
	scanner.close();
	}
}

