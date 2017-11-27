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
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					atualizaInformacoes();
					enviaInformacoes();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public static UTMConcreta getInstance() {
		if (INSTANCE == null)
			INSTANCE = new UTMConcreta();
		return INSTANCE;
	}

}
