package management.system;

interface Transaction {
	void deposit(double amount);
	void withdraw(double amount);
}