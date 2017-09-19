package aula10_ref0;

/**
 * 2.	Inclua uma nova classe GlassHouse, idêntica a WoodenHouse, exceto pelos
 *  métodos buildPillars() e buildWalls(), em que se troca “Wood” por “Glass”. 
 *  Implemente e teste a construção de uma WoodenHouse e de uma GlassHouse, 
 *  refatorando a classe teste HousingClient. OK
 *
 */
public class HousingClient {
	public static void main(String[] args) {
		WoodenHouse woodenhouse = new WoodenHouse();
		woodenhouse.buildHouse();
		System.out.println("************");
		
		// Refatoração: AQUI
		GlassHouse glassnhouse = new GlassHouse();
		glassnhouse.buildHouse();
		System.out.println("************");
	}
}
