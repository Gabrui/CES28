package nullObject;

public abstract class Customer {
	private final String name;

	public Customer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isNil() {
		return false;
	}
}
