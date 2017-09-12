package nullObject;

public class AplicacaoANTES {
	
	@SuppressWarnings("unused")
	public AplicacaoANTES() {
		RealCustomerANTES antes = new RealCustomerANTES("ola");
		RealCustomerANTES antes2 = null;
		
		if (antes != null)
			antes.getName();
		if (antes2 != null)
			antes2.getName();
	}

}
