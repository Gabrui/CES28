package aula10_ref1;

public class HousingClient {
	public static void main(String[] args) {
		WoodenHouse woodenhouse = new WoodenHouse();
		woodenhouse.buildHouse();
		System.out.println("************");
		
		// Refatoração:
		GlassHouse glassnhouse = new GlassHouse();
		glassnhouse.buildHouse();
		System.out.println("************");
	}
}
