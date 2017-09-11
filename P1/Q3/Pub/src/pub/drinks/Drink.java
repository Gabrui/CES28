package pub.drinks;

/**
 * Para facilitar a criação de novas drinks, criei uma package só para ela
 */
import pub.drinks.ingredients.Ingredient;

/**
 * Para facilitar a extensão, cada nova bebida será uma nova classe que herda de Drink
 * @author gabriel
 *
 */
public abstract class Drink {
	private Ingredient[] ingredients = null;
	private int studentDiscount = 0;
	private String name;
	private int basePrice = 0;
	private boolean limited = false;
	private int maxLimit;
	
	protected Drink (String name) {
		this.name = name;
	}
	
	protected void setStudentDiscount (int studentDiscount) {
		this.studentDiscount = studentDiscount;
	}
	
	protected void setBasePrice (int basePrice) {
		this.basePrice = basePrice;
	}
	
	protected void setIngredients(Ingredient[] ingredients) {
		this.ingredients = ingredients;
	}
	
	protected void setLimit(int quant) {
		this.limited = true;
		this.maxLimit = quant;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice(boolean isStudent) {
		int price = this.basePrice;
		if (ingredients != null)
			for (Ingredient i : ingredients) {
				price += i.getPrice();
			}
		if (isStudent)
			return (price - price*studentDiscount/100);
		return price;
	}
	
	public boolean isLimited(int quant) {
		if (this.limited)
			return quant > this.maxLimit;
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Drink) {
			return ((Drink) o).getName().equals(this.getName());
		}
		if (o instanceof String) {
			return ((String) o).equals(this.getName());
		}
		return false;
	}

}
