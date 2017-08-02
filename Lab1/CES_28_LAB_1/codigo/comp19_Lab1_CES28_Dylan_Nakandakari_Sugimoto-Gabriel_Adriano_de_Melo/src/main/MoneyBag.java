/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel
 *
 */
public class MoneyBag implements Pocket{
	List<Money> myList = new ArrayList<Money>();
	/**
	 * 
	 */
	public MoneyBag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pocket add(Money money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean hasMoney() {
		return true;
	}
	
	@Override
	public boolean equals(Object m) {
		return false;
	}

}
