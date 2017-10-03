package aula10_ref3_enum;


public class ApplicationTest {
	public static void main(String[] args) {
		Application app1 = Application.INSTANCE;
		Application app2 = Application.INSTANCE;
		app1.run( );
		app2.run( );
		if (app1 == app2)
			System.out.println ("Same instance");
		else
			System.out.println ("Different instances");
	}
}
