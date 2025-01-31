package management.system;

import java.util.Scanner;
import java.util.HashMap;

public class DepositMoney {
	private HashMap<String, BankAccount> accounts;
	
	DepositMoney(HashMap<String, BankAccount> accounts) {
		this.accounts = accounts;
	}
	
	public void depositToAccount(Scanner scanner) {
		System.out.print("Enter Account Number: ");
		String accountNumber = scanner.nextLine();
		
		BankAccount account = accounts.get(accountNumber);
		
		if(account == null) {
			System.out.println("Account Not Found");
			return;
		}
		
		System.out.print("Enter Amount to Deposit: ");
		double amount = scanner.nextDouble();
		account.deposit(amount);
	}

}

