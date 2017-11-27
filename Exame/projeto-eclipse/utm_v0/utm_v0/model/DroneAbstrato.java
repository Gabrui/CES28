package utm_v0.model;

public abstract class DroneAbstrato {
	protected EscutadorDrones escutador;
	protected InformacaoVoo info;
	
	public DroneAbstrato(EscutadorDrones escutador) {
		this.escutador = escutador;
		this.escutador.registraDrone(this);
		this.info = new InformacaoVoo(0, 0, 0);
	}
	
	/**
	 * Envia suas informações de voo para o escutador
	 */
	public void enviaInformacoesVoo() {
		this.escutador.recebeAtualizacao(this, info);
	}
	
	
	public InformacaoVoo getInformacoesVoo() {
		return info;
	}
	
	public void move(double latitude, double longitude, double altitude) {
		this.info = new InformacaoVoo(
				info.getLatitude()+latitude,
				info.getLongitude()+longitude,
				info.getAltitude()+altitude);
	}

}
