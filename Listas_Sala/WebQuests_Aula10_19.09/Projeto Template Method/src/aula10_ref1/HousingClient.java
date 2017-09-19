package aula10_ref1;

/**
 * A classe de testes HousingClient precisará ser refatorada também?!?
 * NÃO PRECISOU
 */
// A classe HousingClient não precisou ser refatorada
public class HousingClient {
	public static void main(String[] args) {
		WoodenHouse woodenhouse = new WoodenHouse();
		woodenhouse.buildHouse();
		System.out.println("************");
		GlassHouse glassnhouse = new GlassHouse();
		glassnhouse.buildHouse();
		System.out.println("************");
	}
}
