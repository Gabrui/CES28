package aula10_ref1;

/**
 * 2.	Inclua uma nova classe GlassHouse, idêntica a WoodenHouse, exceto pelos
 *  métodos buildPillars() e buildWalls(), em que se troca “Wood” por “Glass”. 
 *  Implemente e teste a construção de uma WoodenHouse e de uma GlassHouse, 
 *  refatorando a classe teste HousingClient.
 *
 */
public class GlassHouse extends AbstractHouse {
	
	protected void buildPillars() {
		System.out.println("Building Pillars with Glass coating");
	}
	protected void buildWalls() {
		System.out.println("Building Glass Walls");
	}
	
}
