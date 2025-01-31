package management.system;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class FileHandler {
	private static final String BANK_ACCOUNT_INFORMATION = "AccountUsersInformation.txt";
	private static final String BANK_ACCOUNT_USERSID = "BankAccountId.txt";
	private static final String BANK_ADMIN_AUTHORIZED = "BankAdminPassword.txt";
	private static BufferedReader reader;
	
	static {
		checkAndCreateFile(BANK_ACCOUNT_INFORMATION);
		checkAndCreateFile(BANK_ACCOUNT_USERSID);
		checkAndCreateFile(BANK_ADMIN_AUTHORIZED);
	}
	
	private static void checkAndCreateFile(String Filename) {
		File file = new File(Filename);
		if (!file.exists()) {
			try {
				if(file.createNewFile()) {
					System.out.println("File created: " + Filename);
				}
			} catch (IOException e) {
				System.out.println("Error creating file: " + Filename + "." + e.getMessage());
			}
		}
	}
	
	//Load the account IDs from BankAccountId.txt andreturn the highest ID number
	public static int loadLastAccountId() {
		int lastAccountId = 0; // Default if no account IDs are present
		try(BufferedReader reader = new BufferedReader(new FileReader(BANK_ACCOUNT_USERSID))) {
			String line;
			while((line = reader.readLine()) != null) {
				if(!line.isEmpty()) {
					int currentId = Integer.parseInt(line.trim());
					lastAccountId = Math.max(lastAccountId, currentId);
				}
			}
		} catch (IOException e) {
			System.out.println("Error loading account numbers: " + e.getMessage());
		}
		return lastAccountId;
		
	}
	
	//Save the new account ID to BankAccountId.txt
	public static void saveAccountNumber(int accountId) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(BANK_ACCOUNT_USERSID, true))) {
			writer.write(String.format("%06d", accountId)); // Format to a 6 digits with leading zero
			writer.newLine();
		} catch (IOException e) {
			System.out.println("Error saving account number: " + e.getMessage());
		}
	}
	
	// Load account number from BankAccountId.txt
	public static HashSet<String> loadAccountId() {
		HashSet<String> loadAccountId = new HashSet<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(BANK_ACCOUNT_USERSID))) {
			String line;
			while ((line = reader.readLine()) != null) {
				loadAccountId.add(line.trim());
			}
		} catch (IOException e) {
			System.out.println("Error loading account numbers: " + e.getMessage());
		}
		return loadAccountId;
	}
	
	//Save AccountNumber/AccountPassword in the BankAccountId
	public static void saveAccountNumber(String loadAccountId) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(BANK_ACCOUNT_USERSID, true))) {
			writer.write(loadAccountId);
			writer.newLine();
		}catch (IOException e) {
			System.out.println("Error saving account number: " + e.getMessage());
		}
	}
	
	// Load Authorized admins from AdminAccess.txt
		public static HashSet<String> loadAccount() {
			HashSet<String> adminPassword = new HashSet<>();
			try (BufferedReader reader = new BufferedReader(new FileReader(BANK_ADMIN_AUTHORIZED))) {
				String line;
				while((line = reader.readLine()) != null) {
					adminPassword.add(line.trim());
				}
			}catch (IOException e) {
				System.out.println("Error loading admin access: " + e.getMessage());
			}
			
			
			return adminPassword;
		}
	
	// Save The BankAccount Information From BankAccount.Txt
	static void saveAccountToFile(BankAccount account) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(BANK_ACCOUNT_INFORMATION, true))) {
			if(account instanceof SavingsAccount) {
				// Save saving account information (with interest rate)
				SavingsAccount savingsAccount = (SavingsAccount) account;
				writer.write(account.getNumber() + "," + account.getHolder() + "," + account.getBalance() + "," + account.getPassword() + "," + savingsAccount.getInterestRate());
			} else {
				// Save Current account information (without interest rate)
				writer.write(account.getNumber() + "," + account.getHolder() + "," + account.getBalance() + "," + account.getPassword());
			}
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			System.out.println("Error while saving account to file: " + e.getMessage());
		}
	}
	
	
	public static HashMap<String, BankAccount> loadAccounToFromFile() {
	    HashMap<String, BankAccount> accounts = new HashMap<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(BANK_ACCOUNT_INFORMATION))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Split each line by the comma delimiter
	            String[] parts = line.split(",");
	            
	            // Ensure there are at least 4 parts (accountNumber, accountHolder, balance, password)
	            if (parts.length >= 4) {
	                String accountNumber = parts[0].trim();  // Trim to remove extra spaces
	                String accountHolder = parts[1].trim();
	                double balance = Double.parseDouble(parts[2].trim());
	                String password = parts[3].trim();  // Read the password from the file
	                
	                if (parts.length == 5) {  // Savings Account with interest rate
	                    double interestRate = Double.parseDouble(parts[4].trim());
	                    accounts.put(accountNumber, new SavingsAccount(accountNumber, accountHolder, balance, password, interestRate));
	                } else {  // Default to Current Account (without interest rate)
	                    accounts.put(accountNumber, new CurrentAccount(accountNumber, accountHolder, balance, password));
	                }
	            } else {
	                // Log or print skipping invalid line for debugging
	                System.out.println("Skipping invalid line (not enough data): " + line);
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Error while loading accounts from file: " + e.getMessage());
	    }
	    return accounts;
	}
}
