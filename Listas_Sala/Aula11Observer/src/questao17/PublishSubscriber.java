package questao17;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PublishSubscriber implements Observer {
	
	private HashMap<Observable, String> publisherAssunto = new HashMap<>();
	private HashMap<String, List<Observer>> assuntoSubscribers = new HashMap<>();

	@Override
	public void update(Observable o, Object arg) {
		noti
	}
	
	public void adiconaPublisher(Observable publisher, String assunto) {
		publisher.addObserver(this);
		publisherAssunto.put(publisher, assunto);
	}

	
}
