package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import presenter.Presenter;
import view.ConsoleView;

public class TestePresenterIntegrado {
	
	Presenter p;
	
	@Before
	public void inicia() {
		p = new Presenter();
	}
	
	@Test
	public void testaConstrucao() {
		assertNotNull(p);
	}

	@Test
	public void testaCalculoInvalido() {
		p.calculaInterpolacao(0);
		assertFalse(p.isResultadoValido());
	}
	
	@Test
	public void testaInterpolacao() {
		p.setArquivoDados("./data.dat");
		p.setMetodoInterpolacao("Lagrange");
		p.calculaInterpolacao(10.3f);
		assertEquals(11.3, p.getUltimoResultado(), 0.01);
		assertTrue(p.isResultadoValido());
	}
	
	@Test
	public void testaMultiplosViews() {
		p.addObserver(new ConsoleView());
		p.addObserver(new ConsoleView());
		p.addObserver(new ConsoleView());
		assertEquals(3, p.countObservers());
	}

}
