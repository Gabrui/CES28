package aula10_ref1;

/**
 * 1. Implementar e testar a classe WoodenHouse 
 * com uma classe de teste HousingClient. 
 * O método buildHouse() pode ficar sem o “final”? 
 * O que o “final” acarreta no código?!?
 * RESPOSTA:
 *
 */
public class WoodenHouse extends AbstractHouse {

	protected void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
	protected void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

}
