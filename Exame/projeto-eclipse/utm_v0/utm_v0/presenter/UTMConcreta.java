package utm_v0.presenter;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.InformacaoVoo;

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
						Thread.sleep(4000); // A cada 4 segundos
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
	
	@Override
	public void recebeAtualizacao(DroneAbstrato d, InformacaoVoo info) {
		super.recebeAtualizacao(d, info);
		System.out.println("UTM: Recebi informações do "+d+" na altitude "+info.getAltitude());
	}

}
