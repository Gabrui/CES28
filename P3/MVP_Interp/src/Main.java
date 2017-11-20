import presenter.Presenter;
import view.ConsoleView;
import view.IView;

public class Main {

	public static void main(String[] args) {
		Presenter p = new Presenter();
		IView v = new ConsoleView(); // Inclue uma view funcional
		v.init(p);
		
		// Simula entrada do usuário
		v.setArquivoDados("./data.dat");
		v.setMetodoInterpolacao("Lagrange");
		v.setPontoInterpolacao(10.3);
	}

}
