import hookClass.ControladorPouso;
import hookClass.PousoRapido;
import hookClass.PousoSeguro;
import hookMethod.*;

public class Principal {

	public static void main(String[] args) {
		// HOOK METHODS
		System.out.println();
		System.out.println("==> Exemplo de Hook methods:");
		Pai p = new Pai();
		p.metodoPrincipal();
		Filho1 f1 = new Filho1();
		f1.metodoPrincipal();
		Filho2 f2 = new Filho2();
		f2.metodoPrincipal();
		
		// HOOK CLASS
		System.out.println();
		System.out.println("==> Exemplo de Hook Class:");
		ControladorPouso c = new ControladorPouso();
		c.setEstrategiaPouso(new PousoSeguro());
		c.executaPouso();
		c.setEstrategiaPouso(new PousoRapido());
		c.executaPouso();
	}

}
