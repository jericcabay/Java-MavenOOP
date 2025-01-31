package management.system;

import java.util.HashMap;
import java.util.Scanner;
import java.io.Console;

public class User {
	private HashMap<String, BankAccount> accounts;

	public User(HashMap<String, BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public void userMenu(Scanner scanner) {
		Console console = System.console();
		
		if(console == null) {
			System.out.println("No console available.");
			return;
		}
		
		// Get password securely
		char[] passwordChars = console.readPassword("Enter Password: ");
		String password = new String(passwordChars);
		
		BankAccount account = null;
		for(BankAccount acc : accounts.values()) {
			if(acc.getPassword().equals(password)) {
				account = acc;	
				break;
			}
		}
		
		//if no Account is found with the password, deny access
		if (account == null) {
			System.out.println("Account Not Found or Incorrect Password");
			return;
		}
		
		//Password is correct Proceed with the user menu
		while (true) {
			System.out.println("\nUser Menu:");
            System.out.println("1. View Account Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch(choice) {
            case 1:
            	System.out.println("Account Details: " + account.displayInformation());
            	break;
            case 2:
            	System.out.print("enter Withdrawal Amount: ");
            	double withdrawAmount = scanner.nextDouble();
            	account.withdraw(withdrawAmount);
            	break;
            case 3:
            	System.out.println("Thank You for using the bank Account Management System");
            	return;
            default:
            	System.out.println("Invalid choice. Please Try Again");
            }
		}
	}
}
