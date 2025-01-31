package management.system;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Corrected constructor to match arguments in BankManagement
    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, String password, double interestRate) {
        super(accountNumber, accountHolder, initialBalance, password); // Ensure matching arguments here
        this.interestRate = interestRate;
    }
    
    public double getInterestRate() {
    	return interestRate;
    }

    @Override
    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Applied: " + interest + ". Balance: " + balance);
    }
    
    @Override
    public String displayInformation1() {
    	return super.displayInformation1() + "," + interestRate;
    }
}
