package aula10_ref0;

/**
 * 1. Implementar e testar a classe WoodenHouse 
 * com uma classe de teste HousingClient. 
 * O método buildHouse() pode ficar sem o “final”? ATÉ QUE PODERIA SEM PROBLEMAS, 
 * 										MAS ELE FOI PENSADO PARA NÃO SER SOBREESCRITO.
 * O que o “final” acarreta no código?!? NÃO DEIXA SOBREESCREVER O MÉTODO, CASO A CLASSE SEJA HERDADA
 * RESPOSTA: DETALHADA NO PDF
 *
 */
public class WoodenHouse {
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
		System.out.println("Building Pillars with Wood coating");
	}
	private void buildWalls() {
		System.out.println("Building Wooden Walls");
	}
	private void buildWindows() {
		System.out.println("Building Glass Windows");
	}
}
