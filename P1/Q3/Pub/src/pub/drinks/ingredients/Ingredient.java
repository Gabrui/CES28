package pub.drinks.ingredients;

/**
 * Para facilitar a criação de novos ingredientes, pensando no contexto de um banco de dados
 * criei uma classe Pai que deve ser herdada por novos ingredientes.
 * @author gabriel
 *
 */
public abstract class Ingredient {
	private String name;
	private int price;
	
	Ingredient (String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	// Método pensando já no futuro.
	public String getName() {
		return name;
	}

}
