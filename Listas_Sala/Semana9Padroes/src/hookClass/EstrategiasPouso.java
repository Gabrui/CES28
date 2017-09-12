package hookClass;

public abstract class EstrategiasPouso {
	public int calculaVelocidadeOtima(int altitude, int distancia) {
		return 100 + dadosInternos(altitude) + distancia;
	}
	
	protected int dadosInternos(int dado) {
		return dado + 1;
	}
}
