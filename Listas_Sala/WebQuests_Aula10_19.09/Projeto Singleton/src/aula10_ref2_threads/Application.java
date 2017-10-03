package aula10_ref2_threads;

public class Application {

	// ---------- Constructor --------------------
	private     Application() {
		//  Construct object 
		// …
	}    // constructor: Application

	// ---------- Operations --------------------
	// For lazy initialization
	public static synchronized Application getApplication() {
		System.out.println("Locking");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (! instanceFlag) {
			return create();
		} else {
			System.out.println("Freeing");
			return _theApplication;
		}
	}    // method: getApplication

	private static Application create() {
		_theApplication = new Application();
		instanceFlag = true;
		System.out.println("Freeing");
		return _theApplication;
	}    // method: create

	protected void finalize() throws Throwable {
		try {
			instanceFlag = false;        // free new singleton instance!
		} finally {
			super.finalize();
		}
	}    // method: finalize

	// Others methods protected by singleton-ness would be here
	// …

	// ---------- Attributes --------------------  
	private static Application _theApplication = null;
	private static Boolean instanceFlag = false;
	
	public void run() {
		System.out.println("RODANDO O SINGLETON: "+this);
	}

}    // class: Application


