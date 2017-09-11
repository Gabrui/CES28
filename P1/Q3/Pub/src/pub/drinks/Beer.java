package pub.drinks;

public class Beer extends Drink {
	public Beer () {
		super("hansa");
		this.setStudentDiscount(10);
		this.setBasePrice(74);
	}
}
