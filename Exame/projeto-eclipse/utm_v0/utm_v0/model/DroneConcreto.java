package utm_v0.model;

/**
 * Uma implementação de drone 
 * @author gabriel
 *
 */
public class DroneConcreto extends DroneAbstrato {
	private String nome;

	public DroneConcreto(EscutadorDrones escutador, double velo, String nome) {
		super(escutador);
		this.nome = nome;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					move(velo, velo, velo);
					enviaInformacoesVoo();
					try {
						Thread.sleep(3000); // A cada 3 segundos envia informação
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
