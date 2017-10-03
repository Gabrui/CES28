package aula10_ref4_pool;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


/*
 * Estabelecer uma classe Application onde se pode criar até 5 instâncias
de um objeto demorado para criar (insira um sleep de 3 segundos no construtor).
 */
public class Application {
	private static LinkedList<Application> livres = new LinkedList<Application>(Arrays.asList(new Application(), new Application()));
	private static LinkedList<Application> usados = new LinkedList<>();
	private static int maxInstance = 3;
	
	public void run () {
		System.out.println("RODANDO O SINGLETON: "+this);
	}

	
	public static synchronized void release(Application app) {
		app.reiniciar();
		usados.remove(app);
		livres.add(app);
	}
	
	
	public static synchronized Application getApplication() {
		System.out.println("Locking");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (livres.isEmpty()) {
			System.out.println("Freeing");
			return create();
		} else {
			Application reusada = livres.removeLast();
			usados.add(reusada);
			System.out.println("Freeing");
			return reusada;
		}
	}    // method: getApplication


	private Application() {
		// Fazendo gerar a aplication lenta
		try {
			System.out.println("Criando novo objeto");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Application create() {
		if (livres.size()+usados.size() >= maxInstance)
			throw new RuntimeException("Criado de mais");
		Application nova = new Application();
		usados.add(nova);
		return nova;
	}
	
	
	private void reiniciar() {
		// Código para reiniciar os atributos desse objeto
	}

}

