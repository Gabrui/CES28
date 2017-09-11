package pub.drinks;

import pub.drinks.ingredients.*;

public class BacardiSpecial extends Drink {
	public BacardiSpecial() {
		super("bacardi_special");
		Ingredient[] ings = {new Rum(), new Grenadine(), new LimeJuice(), new Gin()};
		this.setIngredients(ings);
		this.setLimit(2);
	}
}
