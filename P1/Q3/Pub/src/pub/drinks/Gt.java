package pub.drinks;
import pub.drinks.ingredients.*;

public class Gt extends Drink {
	public Gt () {
		super("gt");
		Ingredient[] ings = {new GreenStuff(), new TonicWater(), new Gin()};
		this.setIngredients(ings);
		this.setLimit(2);
	}
}
