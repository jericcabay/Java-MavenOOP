package management.system;

//Abstract Base Class
abstract class BankAccount implements Transaction {
	private String accountNumber;
	private String accountHolder;
	private String password;
	protected double balance;
	
	//Abstract Base Class
	public BankAccount(String accountNumber, String accountHolder, double balance, String password) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.password = password;
		this.balance = balance;
	}

	
	// Get Method 
	public String getNumber() {
		return accountNumber;
	}
	
	public String getHolder() {
		return accountHolder;
	}
	
	public String getPassword() {
		return password;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//Abstract method for account specific interest
	public abstract void applyInterest();
	
	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Balance: " + amount);
		} else {
			System.out.println("Invalid deposit");
		}
	} 
	
	@Override
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Balance: " + amount);
		} else {
			System.out.println("insufficient Balance");
		}
	}
	
	public String displayInformation() {
		return "Acount Number: " + accountNumber + "\n" + 
				"Account Holder:  "+ accountHolder + "\n" +
				"Account Balance: " + balance + "\n";
	}
	
	public String displayInformation1() {
		return accountNumber + ",        " + accountHolder + ",           " + balance;
	}
}