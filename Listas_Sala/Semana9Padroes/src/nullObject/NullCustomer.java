package nullObject;

public class NullCustomer extends Customer {
	public NullCustomer() {
		super("");
	}
	
	@Override
	public String getName() {
		return "";
	}
	
	@Override
	public boolean isNil() {
		return true;
	}
}
