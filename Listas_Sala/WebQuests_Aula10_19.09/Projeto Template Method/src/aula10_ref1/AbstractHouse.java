package aula10_ref1;
/**
 * Faça uma refatoração que use o padrão Template Method e elimine o mau cheiro,
 *  em que se considera que apenas os métodos buildPillars() e buildWalls() é que
 *   serão sobrepostos (overrided) nas subclasses do padrão. OK
 *   
 *   a.	Implemente e teste o sistema na nova estrutura. OK
        Você deve manter o método buildHouse() como final nessa reestruturação? SIM
        A classe de testes HousingClient precisará ser refatorada também?!? NÃO
        
    c.	Neste caso, identifique o método template, a classe template, os métodos hook, 
    a classe hook e os métodos que não são nada disso. OK
 */
// ESSA É A CLASSE TEMPLATE e classe hook ao mesmo tempo
public abstract class AbstractHouse {
	// ESSE É O MÉTODO TEMPLATE
	public final void buildHouse(){ // DEVE SER OBRIGATORIAMENTE FINAL, POIS É TEMPLATE
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}
	protected void buildFoundation() { // MÉTODO QUE NÃO É NADA
		System.out.println("Building foundation with cement,iron rods and sand");
	}
	
	abstract protected void buildPillars(); // Método hook
	abstract protected void buildWalls(); // Método hook
	
	protected void buildWindows() { // MÉTODO QUE NÃO É NADA
		System.out.println("Building Glass Windows");
	}
}
