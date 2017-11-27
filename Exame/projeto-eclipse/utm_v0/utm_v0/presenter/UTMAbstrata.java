package utm_v0.presenter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.EscutadorDrones;
import utm_v0.model.InformacaoVoo;

public abstract class UTMAbstrata extends Observable implements EscutadorDrones {
	
	protected LinkedList<DroneAbstrato> dronesRegistrados;
	protected HashMap<DroneAbstrato, InformacaoVoo> informacoesDrones;
	protected SistemaMapas info;
	private static UTMAbstrata INSTANCE;
	
	public static UTMAbstrata getInstance() {
		return INSTANCE;
	}
	
	// A classe abstrata não pode ser instanciada, a sua filha é singleton.
	protected UTMAbstrata() {
		this.dronesRegistrados = new LinkedList<>();
		this.informacoesDrones = new HashMap<>();
		info = new SistemaMapas("Céu Claro", "São José dos Campos", "");
	}

	@Override
	public void registraDrone(DroneAbstrato d) {
		this.dronesRegistrados.add(d);
	}

	@Override
	public void recebeAtualizacao(DroneAbstrato d, InformacaoVoo info) {
		informacoesDrones.put(d, info);
	}
	
	public SistemaMapas getSistemaMapas() {
		return info;
	}
	
	public void enviaInformacoes() {
		this.setChanged();
		this.notifyObservers(info);
	}
	
	public void atualizaInformacoes() {
		this.info = new SistemaMapas(info.getClima(), info.getMapa(), 
				"Há " + informacoesDrones.size() + "drones registrados.");
	}

}
