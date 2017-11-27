package utm_v0.model;

public interface EscutadorDrones {
	public void registraDrone(DroneAbstrato d);
	public void recebeAtualizacao(DroneAbstrato d, InformacaoVoo info);

}
