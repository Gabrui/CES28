package aula10_ref0;

public class ApplicationTest {
	public static void main(String[] args) {
		Application app1 = Application.getApplication();
		app1.run( );
		Application app2 = Application.getApplication();
		app2.run( );
		if (app1 == app2)
			System.out.println ("Same instance");
		else
			System.out.println ("Different instances");
	}
}
