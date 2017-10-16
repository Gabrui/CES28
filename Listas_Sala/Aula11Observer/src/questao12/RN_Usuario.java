package questao12;

import java.util.Observable;

public class RN_Usuario extends Observable {
	
	private String estado;
	
	public void setEstado(String s) {
		this.estado = s;
		this.setChanged();
		this.notifyObservers();
	}
	
	public String getEstado() {
		return this.estado;
	}
}
