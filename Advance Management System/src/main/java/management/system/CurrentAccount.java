package management.system;

public class CurrentAccount extends BankAccount {
	private double overdraftLimit;
	
	
	public CurrentAccount(String accountNumber, String accountHolder, double initialBalance, String password) {
		super(accountNumber, accountHolder, initialBalance, password);
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount > 0 && amount <= (balance + overdraftLimit)) {
			balance -= amount;
			System.out.println("Withdrew: " + amount + ". New Balance: " + balance);
		} else {
			System.out.println("Invalid withdrawal amount or exceeds overdraft limit.");
		}
	}

	@Override
	public void applyInterest() {
		System.out.println("No interest applicable for current account.");
	}
}
