package utm_v0.model;

public abstract class DroneAbstrato {
	
	protected EscutadorDrones escutador;
	protected InformacaoVoo info;
	
	public DroneAbstrato(EscutadorDrones escutador) {
		this.escutador = escutador;
		this.escutador.registraDrone(this);
	}
	
	protected void enviaInformacoesVoo() {
		this.escutador.recebeAtualizacao(this, info);
	}
	
	public InformacaoVoo getInformacoesVoo() {
		return info;
	}
}
