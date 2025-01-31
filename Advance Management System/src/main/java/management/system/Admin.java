package management.system;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Admin {

	private static final String ADMIN_PASSWORD = "admin1234";
	private HashMap<String, BankAccount> accounts;
	private HashSet<String> accountNumbers;
	private HashSet<String> authorizedAdmins;
	
	public Admin(HashMap<String, BankAccount> accounts, HashSet<String> accountNumbers, HashSet<String> authorizedAdmins) {
		this.accounts = accounts;
		this.accountNumbers = accountNumbers;
		this.authorizedAdmins = authorizedAdmins;
	}
	
	public void adminMenu(Scanner scanner) {
		System.out.print("Admin Password");
		String password = scanner.nextLine();
		
		if (!authorizedAdmins.contains(password)) {
			System.out.println("Unauthorized admin. Exiting");
			return;
		}
		
		RegisterAccount registerAccount = new RegisterAccount(accounts, accountNumbers);
		DepositMoney moneyDeposit = new DepositMoney(accounts);
		
		while (true) {
			System.out.println("\nAdmin Menu:");
            System.out.println("1. Register New Account");
            System.out.println("2. Deposit Money to Account");
            System.out.println("3. Exit");
            
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
            case 1:
            	registerAccount.RegisterNewAccount(scanner);
            	break;
            case 2:
            	moneyDeposit.depositToAccount(scanner);
            	break;
            case 3:
            	System.out.println("Exiting The System.");
            	return;
            default:
            	System.out.println("Invalid choice. Please try again");
            } 
		}
	}
}
