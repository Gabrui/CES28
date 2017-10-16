package questao11;

import java.util.LinkedList;
import java.util.List;

public abstract class Subject {
	private List<Observer> listaObservers = new LinkedList<Observer>();
	
	public void attach(Observer o) {
		listaObservers.add(o);
	}
	
	public void detach(Observer o) {
		listaObservers.remove(o);
	}
	
	protected void notificar() {
		for (Observer o : listaObservers)
			o.update();
	}
	
	
}
