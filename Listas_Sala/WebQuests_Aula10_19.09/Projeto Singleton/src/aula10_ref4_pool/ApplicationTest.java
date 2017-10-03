package aula10_ref4_pool;


public class ApplicationTest implements Runnable {
	public void run() {
		Application app1 = null;
		Application app2 = null;
		try {
			app1 = Application.getApplication();
			app1.run( );
			app2 = Application.getApplication();
			app2.run( );
			if (app1 == app2)
				System.out.println ("Same instance");
			else
				System.out.println ("Different instances");
			Application.release(app1);
			Application.release(app2);
		} catch (RuntimeException e) {
			System.out.println("Não deu para criar");
		}
	}

}
