package aula10_ref0;

/**
 * 2.	Inclua uma nova classe GlassHouse, idêntica a WoodenHouse, exceto pelos
 *  métodos buildPillars() e buildWalls(), em que se troca “Wood” por “Glass”. 
 *  Implemente e teste a construção de uma WoodenHouse e de uma GlassHouse, 
 *  refatorando a classe teste HousingClient.
 *  OK
 *
 */
public class GlassHouse {
	public final void buildHouse(){
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}
	private void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
	private void buildPillars() {
		System.out.println("Building Pillars with Glass coating");
	}
	private void buildWalls() {
		System.out.println("Building Glass Walls");
	}
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}
}
