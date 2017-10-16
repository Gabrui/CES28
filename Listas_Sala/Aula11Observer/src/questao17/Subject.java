package questao17;

import java.util.Observable;

public class Subject extends Observable {
	
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
