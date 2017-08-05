/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes de teste
 */
package main;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Gabriel
 *
 */
public class MoneyBag implements Pocket{
	private List<Money> lista;
	/**
	 * 
	 */
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
		this.lista.add(money.clone());
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
	
	
	public boolean hasMoney(Money money) {
		return this.lista.contains(money);
	}
	
	
	public boolean hasCurrency(Currency curr) {
		for (Money dim : this.lista) {
			if (dim.getCurrency().equals(curr))
				return true;
		}
		return false;
	}
	
	
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
		String resposta = "";
		for (Money dim : this.lista) {
			resposta = resposta + ", " + dim.toString();
		}
		return resposta.substring(2);
	}
	
	
	@Override
	public MoneyBag clone() {
		MoneyBag a = new MoneyBag();
		for (Money dim : this.lista) {
			a.add(dim.clone());
		}
		return a;
	}

}
