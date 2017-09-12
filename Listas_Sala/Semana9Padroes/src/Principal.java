import hookClass.ControladorPouso;
import hookClass.PousoRapido;
import hookClass.PousoSeguro;
import hookMethod.*;

public class Principal {

	public static void main(String[] args) {
		// HOOK METHODS
		System.out.println();
		System.out.println("==> Exemplo de Hook methods:");
		Impressora p = new Impressora();
		p.metodoPrincipal();
		ImpressoraAzul f1 = new ImpressoraAzul();
		f1.metodoPrincipal();
		ImpressoraVerde f2 = new ImpressoraVerde();
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
