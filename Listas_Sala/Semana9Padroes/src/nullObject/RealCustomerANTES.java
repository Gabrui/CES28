package nullObject;

public class RealCustomerANTES {
	private final String name;

	public RealCustomerANTES(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isNil() {
		return false;
	}
}
