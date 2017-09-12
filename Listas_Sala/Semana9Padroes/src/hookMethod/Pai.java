package hookMethod;

public class Pai {
	
	public void metodoPrincipal() {
		System.out.println("Executando método principal");
		this.logicaInterna();
	}
	
	protected void logicaInterna() {
		System.out.println("Sou inteno da classe Pai");
	}

}
