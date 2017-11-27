package utm_v0.presenter;

public class SistemaMapas {
	private String clima;
	private String mapa;
	private String outros;

	public SistemaMapas(String clima, String mapa, String outros) {
		this.clima = clima;
		this.mapa = mapa;
		this.outros = outros;
	}
	
	public String getClima() {
		return clima;
	}

	public String getMapa() {
		return mapa;
	}

	public String getOutros() {
		return outros;
	}
	
	@Override
	public String toString() {
		return "Sistema de mapa\n"
				+ "Clima: "+clima
				+ "\nLocal: "+mapa +"\n" + outros;
	}
}
