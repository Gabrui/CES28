package nullObject;

public class AplicacaoDepois {
	
	public AplicacaoDepois() {
		Customer depois = new RealCustomer("ola");
		Customer depois2 = new NullCustomer();
		
		depois.getName();
		depois2.getName();
	}
}
