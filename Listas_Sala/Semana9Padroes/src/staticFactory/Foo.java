package staticFactory;

public class Foo {
	private Foo(boolean withBar){
	    //...
	}
	
	// Resolvemos o problema com o static factory pattern
	public static Foo createWithBar() {
		return new Foo(true);
	}
	
	public static Foo createWithoutBar() {
		return new Foo(false);
	}

}
