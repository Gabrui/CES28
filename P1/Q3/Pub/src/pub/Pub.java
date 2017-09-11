/**
 * Identifiquei os substantivos que são potenciais classes:
 * 		Drink, Ingredient, que serão classes pais dos específicos.
 */

package pub;

import java.util.LinkedList;

import pub.drinks.*;

public class Pub {
	
	private LinkedList<Drink> drinks;
	
	public Pub() {
		drinks = new LinkedList<>();
		this.addDrink(new Beer());
		this.addDrink(new Cider());
		this.addDrink(new ProperCider());
		this.addDrink(new Gt());
		this.addDrink(new BacardiSpecial());
	}
	
	private void addDrink(Drink drink) {
		this.drinks.add(drink);
	}


    public int computeCost(String drink, boolean student, int amount) {
    	for (Drink d : drinks) {
    		if (d.equals(drink)) {
    			if (d.isLimited(amount))
    				throw new RuntimeException("Too many drinks, max 2.");
    			else
    				return amount * d.getPrice(student);
    		}
    	}
    	throw new RuntimeException("No such drink exists");
    }

}
