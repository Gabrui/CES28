/**
 * LAB-1 CES-28
 * @date   01/08/2017
 * @author Dylan N. Sugimoto
 * @author Gabriel Adriano de Melo
 * 
 * Esse pacote guarda a classe Money e a classe MoneyBag
 */
package main;

/**
 * @version 1.0, 01/08/2017
 * @param {_amount} representa a quantidade da moeda (inteiro positivo) 
 * @param {_currency} representa o tipo da moeda (string de tres letras)
 * 
 * metodo setAmount: estabelece o valor da variavel _amount
 * metodo setCurrency: estabelece o valor da variavel _currency
 * metodo add: adiciona uma Money
 * metodo getAmount: retorna o valor de _amount
 * metodo getCurrency: retorna o valor de _currency
 */
public class Money implements Pocket{
	private int amount;
	private Currency currency;
	/**
	 * 
	 * @param amount
	 * @param currency
	 */
	public Money(int amount, Currency currency) {
		setAmount(amount);
		setCurrency(currency);
	}
	
	
	public void setAmount(int amount) {
		if(amount < 0) {
			
			throw new ArithmeticException("amount não deve ser negativo!");
		}
		this.amount = amount;
	}
	
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	
	public Pocket add(Money money) {
		if(this.getCurrency().equals(money.getCurrency())){
			return new Money(this.getAmount() + money.getAmount(), this.getCurrency());
		}
		return money;
	}
	
	
	public int getAmount() {
		return this.amount;
	}
	
	
	public Currency getCurrency() {
		return this.currency.clonar();
	}
	
	@Override
	public boolean equals(Object money) {
		if (money instanceof Money) {
			Money m = (Money) money;
			return this.currency.equals(m.currency) && this.getAmount() == m.getAmount();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getAmount() + " " + this.getCurrency().toString();
	}
}
