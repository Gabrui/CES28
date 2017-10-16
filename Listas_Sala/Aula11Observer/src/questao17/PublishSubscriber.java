package questao17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class PublishSubscriber implements Observer {
	
	private HashMap<Observable, String> publisherAssunto = new HashMap<>();
	private HashMap<String, List<Observer>> assuntoSubscribers = new HashMap<>();

	@Override
	public void update(Observable publisher, Object arg) {
		for (Observer subscriber : assuntoSubscribers.get(publisherAssunto.get(publisher)))
			subscriber.update(null, arg);
	}
	
	public void adiconaPublisher(Observable publisher, String assunto) {
		publisher.addObserver(this);
		publisherAssunto.put(publisher, assunto);
	}
	
	public void addSubscriber(Observer subscriber, String assunto) {
		List<Observer> lista = assuntoSubscribers.get(assunto);
		if (lista != null)
			lista.add(subscriber);
		else {
			lista = new LinkedList<>();
			lista.add(subscriber);
			assuntoSubscribers.put(assunto, lista);
		}
	}

	
}
