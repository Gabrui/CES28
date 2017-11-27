package utm_v0.presenter;

import java.util.LinkedList;
import java.util.Observable;

import utm_v0.model.DroneAbstrato;
import utm_v0.model.EscutadorDrones;
import utm_v0.model.InformacaoVoo;

public abstract class UTMAbstrata extends Observable implements EscutadorDrones {
	
	protected LinkedList<DroneAbstrato> dronesRegistrados;
	private static UTMAbstrata INSTANCE;
	
	public static UTMAbstrata getInstance() {
		return INSTANCE;
	}
	
	// A classe abstrata não pode ser instanciada, a sua filha é singleton.
	protected UTMAbstrata() {
		this.dronesRegistrados = new LinkedList<>();
	}

	@Override
	public void registraDrone(DroneAbstrato d) {
		this.dronesRegistrados.add(d);
	}

	@Override
	public void recebeAtualizacao(DroneAbstrato d, InformacaoVoo info) {
		// TODO Auto-generated method stub
		
	}

}
