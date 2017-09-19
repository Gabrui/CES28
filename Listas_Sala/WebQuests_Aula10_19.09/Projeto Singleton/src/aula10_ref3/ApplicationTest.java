package aula10_ref3;

// Atividade: A propósito, como se poderia testar a classe singleton agora?
// SE TESTA DA MESMA FORMA
public class ApplicationTest {
	public static void main(String[] args) {
		Application app1 = Application.INSTANCE;
		app1.run( );
		Application app2 = Application.INSTANCE;
		app2.run( );
		if (app1 == app2)
			System.out.println ("Same instance");
		else
			System.out.println ("Different instances");
	}
}
