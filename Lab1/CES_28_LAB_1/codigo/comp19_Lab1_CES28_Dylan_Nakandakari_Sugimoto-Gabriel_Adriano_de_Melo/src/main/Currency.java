/**
 * 
 */
package main;

/**
 * @author gabrui
 *
 */
public class Currency {
	private String nome;
	
	public Currency (String currency) {
		this.nome = currency;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Currency clonar() {
		return new Currency(this.getNome());
	}
	
	public Boolean equals(Currency curr) {
		return this.getNome().equals(curr.getNome());
	}
}
