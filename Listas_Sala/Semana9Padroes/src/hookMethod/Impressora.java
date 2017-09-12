package hookMethod;

public class Impressora {
	
	public void metodoPrincipal() {
		System.out.println("Executando impressão");
		this.logicaInterna();
	}
	
	protected void logicaInterna() {
		System.out.println("Impressão configurada genericamente");
	}

}
