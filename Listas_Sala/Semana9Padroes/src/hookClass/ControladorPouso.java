package hookClass;

public class ControladorPouso {
	
	private EstrategiasPouso est;
	
	public void setEstrategiaPouso(EstrategiasPouso est) {
		this.est = est;
	}
	
	public void executaPouso() {
		int d = est.calculaVelocidadeOtima(100, 3000);
		System.out.println(d);
	}
}
