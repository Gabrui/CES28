package item2_solucao;

public abstract class BankAccount {
	// Class Description: Checking and Savings Account
	public double Balance() {
		return _balance;
	};
	
	public void Deposit(double amount) {
		_balance += amount;
	};
	
	public void Withdraw(double amount) {
		_balance -= amount;
	};

	private double _balance;
}
