package aula10_ref1;

public class Application {
	public void run () {
		
	}


	private     Application() {
		
	}


	public static Application    getApplication() {
		if (_theApplication == null) {
			_theApplication = new Application();
		}
		return _theApplication;       
	}

	private static Application    _theApplication = null;

}

