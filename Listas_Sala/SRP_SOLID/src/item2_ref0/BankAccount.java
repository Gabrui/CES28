package item2_ref0;

public abstract class BankAccount {
	// Class Description: Checking and Savings Account
	public double Balance() {return _balance;};
	public void Deposit(double amount) {};
	public void Withdraw(double amount) {};
	public void AddInterest(double amount) {};
	public void Transfer(double amount, BankAccount toAccount) {};

	private double _balance;
}
