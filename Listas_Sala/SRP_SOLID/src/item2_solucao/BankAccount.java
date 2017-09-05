package item2_solucao;
/**
 * 
 * @author Gabriel Adriano
 * @author Dylan Sugimoto
 * O arquivo original não tinha uma responsabilidade única de representar uma
 * conta abstrata, segundo as especificações do projeto.
 * Haviam responsabilidades de contas corrente e poupança juntas, que foram 
 * refatoradas de forma a respeitar o princípio de responsabilidade única.
 */
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
