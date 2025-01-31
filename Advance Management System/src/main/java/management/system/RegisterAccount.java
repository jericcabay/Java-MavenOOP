package management.system;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RegisterAccount {
	private HashMap<String, BankAccount> accounts;
	private HashSet<String> accountNumbers;
	
	public RegisterAccount (HashMap<String, BankAccount> accounts, HashSet<String> accountNumbers) {
	this.accounts = accounts;
	this.accountNumbers = accountNumbers;
	}
	
	public void RegisterNewAccount(Scanner scanner) {
		// Auto-generate account number
		int lastAccountId = FileHandler.loadLastAccountId();
		
		
		int newAccountId =  lastAccountId + 1;
		String newAccountID = String.format("%06d", newAccountId);
		System.out.println("Generate Account Id: " + newAccountID);
		
		System.out.print("Enter Account Holder: ");
		String accountHolder = scanner.nextLine();
		
		System.out.print("Enter a New Password: ");
		String password = scanner.next();
		
		System.out.print("Enter Initial Balance: ");
		double balance = scanner.nextDouble();
		
		System.out.print("Enter Interest Rate: ");
		double interestRate = scanner.nextDouble();
		
		BankAccount newAccount;
		
		if (interestRate > 0) {
			newAccount = new SavingsAccount(newAccountID, accountHolder, balance, password, interestRate);
		} else {
			newAccount = new CurrentAccount(newAccountID, accountHolder, balance, password);
		}
		
		accounts.put(newAccountID, newAccount);
		accountNumbers.add(newAccountID);
		
		
		FileHandler.saveAccountToFile(newAccount);
		FileHandler.saveAccountNumber(newAccountID);
		
		System.out.println("Account Created successfully");
	}
}

