package utm_v0.presenter;


/**
 * O padrão de design Singleton satisfaz o problema 5.C
 * @author gabriel
 *
 */
public class UTMConcreta extends UTMAbstrata {
	
	private static UTMConcreta INSTANCE;
	
	private UTMConcreta() {
		super();
	}
	
	public static UTMConcreta getInstance() {
		if (INSTANCE == null)
			INSTANCE = new UTMConcreta();
		return INSTANCE;
	}

}
