/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @encoding UTF-8
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes principais, isto é, implementadas
 */
package main;

import java.util.LinkedList;
import java.util.List;


/**
 * Representa a MoneyBag conforme as especificações.
 */
public class MoneyBag implements Pocket{
	private List<Money> lista;
	
	public MoneyBag() {
		this.lista = new LinkedList<Money>();
	}
	
	public MoneyBag(Money a, Money b) {
		this.lista = new LinkedList<Money>();
		this.add(a);
		this.add(b);
	}
	
	
	@Override
	public Pocket add(Money money) {
		for (Money dim : this.lista) {
			if (dim.getCurrency().equals(money.getCurrency())) {
				dim.setAmount(dim.getAmount() + money.getAmount());
				return this;
			}
		}
		// Os elementos da lista não são os mesmos que os originais
		this.lista.add(money.clonar());
		return this;
	}

	
	@Override
	public int getAmount() {
		int total = 0;
		for (Money dim : this.lista) {
			total += dim.getAmount() * dim.getCurrency().getTaxaDeCambioParaReais();
		}
		return total;
	}
	
	/**
	 * Verifica se a MoneyBag tem o dinheiro, que inclusive pode ter valor 0.
	 * @param money Dinheiro a ser procurado
	 * @return Retorna verdadeiro caso tenha o mesmo dinheiro.
	 */
	public boolean hasMoney(Money money) {
		return this.lista.contains(money);
	}
	
	/**
	 * Verifica se a MoneyBag tem a moeda especificada, mesmo que não haja valor.
	 * @param curr Moeda a ser verificada
	 * @return Retorna verdadeiro caso haja a moeda.
	 */
	public boolean hasCurrency(Currency curr) {
		for (Money dim : this.lista) {
			if (dim.getCurrency().equals(curr))
				return true;
		}
		return false;
	}
	
	/**
	 * Mesmo que hajam moedas vazias, conta todas elas.
	 * @return A quantidade de diferentes moedas
	 */
	public int getSize() {
		return this.lista.size();
	}
	
	
	@Override
	public boolean equals(Object moneyBag) {
		if (moneyBag instanceof MoneyBag) {
			MoneyBag m = (MoneyBag) moneyBag;
			if (this.lista.size() != m.lista.size())
				return false;
			for (Money dim : this.lista) {
				if (!m.hasMoney(dim))
					return false;
			}
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		if (this.getSize() == 0)
			return "";
		String resposta = "";
		for (Money dim : this.lista) {
			resposta = resposta + ", " + dim.toString();
		}
		return resposta.substring(2);
	}
	
	
}
