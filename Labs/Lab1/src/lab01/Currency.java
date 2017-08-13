/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @encoding UTF-8
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes principais, isto é, implementadas
 */
package lab01;

/**
 * PASSO 5 - CLASSE CURRENCY CONSTRUIDA E INJETADA
 * Descreve um tipo de moeda
 * Possui PASSO 5.
 */
public class Currency {
	private String sigla;
	
	public Currency (String sigla) {
		setSigla(sigla);
	}
	
	/**
	 * Retorna uma nova string que representa essa currency
	 * @return Uma string que representa a moeda
	 */
	public String getSigla() {
		return this.sigla;
	}
	
	/**
	 * Troca a string de sigla.
	 * @throws Erro do tamanho da sigla diferente de 3
	 * @param sigla String que define a sigla da moeda.
	 */
	private void setSigla (String sigla) {
		if (sigla.length() != 3) {
			throw new SiglaDeCurrencyException("Sigla inválida");
		}
		this.sigla = sigla;
	}
	
	/**
	 * Retorna quantaz vezes essa moeda vale mais que o Real.
	 * @return Taxa de câmbio
	 */
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
	
	/**
	 * Cria uma cópia do próprio objeto
	 * @return Novo objeto clonado
	 */
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
