package utm_v0.model;

/**
 * Uma implementação de drone 
 * @author gabriel
 *
 */
public class DroneConcreto extends DroneAbstrato {

	public DroneConcreto(EscutadorDrones escutador) {
		super(escutador);
		double velo = 10;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					move(velo, velo, velo);
					enviaInformacoesVoo();
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();;
	}
}
