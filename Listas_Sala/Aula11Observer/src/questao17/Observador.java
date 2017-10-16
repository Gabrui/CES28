package questao17;

import java.util.Observable;
import java.util.Observer;

public class Observador implements Observer {
	
	private String id;
	
	public Observador(String id) {
		this.id = id;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(id+" recebi:\n"+arg+"\n");
	}

}
