package questao12;

import java.util.Observable;
import java.util.Observer;

public class UI_TelaConversa implements Observer {
	
	private String id;
	protected RN_Usuario regras;
	
	public UI_TelaConversa(RN_Usuario regras, String id) {
		this.id = id;
		this.regras = regras;
		regras.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(id+" notificado:\n"+regras.getEstado()+"\n");
	}

}
