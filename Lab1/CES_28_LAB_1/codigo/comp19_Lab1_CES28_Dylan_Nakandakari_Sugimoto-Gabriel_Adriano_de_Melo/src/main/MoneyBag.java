/**
 * 
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
	
	
	@Override
	public Pocket add(Money money) {
		for (Money dim : this.lista) {
			if (dim.getCurrency().equals(money.getCurrency())) {
				this.lista.remove(dim);
				this.lista.add((Money) dim.add(money));
				return this;
			}
		}
		this.lista.add(money);
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
		return this.lista.toString();
	}

}
