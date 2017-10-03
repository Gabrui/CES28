package aula10_ref4_pool;
/*
 * Estabelecer uma classe Application onde se pode criar até 5 instâncias
de um objeto demorado para criar (insira um sleep de 3 segundos no construtor).
 */
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

