/**
 * 
 */
package main;

/**
 * @author gabrui
 *
 */
public class Currency {
	private String sigla;
	
	public Currency (String sigla) {
		setSigla(sigla);
	}
	
	
	public String getSigla() {
		return this.sigla;
	}
	
	
	public void setSigla (String sigla) {
		if (sigla.length() != 3) {
			throw new SiglaDeCurrencyException("Sigla inválida");
		}
		this.sigla = sigla;
	}
	
	
	public int getTaxaDeCambioParaReais() {
		// TODO Colocar as siglas em um dicionário
		if (this.sigla.equals("USD"))
			return 3;
		if (this.sigla.equals("EUR"))
			return 4;
		if (this.sigla.equals("CHF"))
			return 2;
		return 1;
	}
	
	
	public Currency clonar() {
		return new Currency(this.getSigla());
	}
	
	
	@Override
	public boolean equals(Object curr) {
		if (curr instanceof Currency) {
			Currency c = (Currency) curr;
			return this.getSigla().equals(c.getSigla());
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return this.sigla;
	}
}
