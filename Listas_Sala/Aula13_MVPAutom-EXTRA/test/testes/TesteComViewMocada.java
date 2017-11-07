package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.Automat;
import presenter.IBoardView;
import presenter.Presenter;

public class TesteComViewMocada {
	
	private Presenter p;
	private Automat a;
	@Mock private IBoardView v;
	
	@Before
	public void iniciar() {
		a = new Automat(10, 10);
		p = new Presenter(a);
		MockitoAnnotations.initMocks(this);
		p.addObserver(v);
	}

	@Test
	public void testeInicializacao() {
		assertNotNull(a);
		assertNotNull(p);
		assertNotNull(v);
	}
	
	@Test
	public void testaNext() {
		p.nextClicked();
		Mockito.verify(v, Mockito.times(1)).update(p, null);
	}
	
	@Test
	public void testaMudancaAutomado() {
		p.changeAutomatCellState(0, 0, 1);
		Mockito.verify(v, Mockito.times(1)).update(p, null);
	}
	
	@Test
	public void testaGetEstados() {
		assertEquals(10, p.getEstados().length);
		assertEquals(10, p.getEstados()[0].length);
	}
	
	@Test
	public void testaMudancaEstados() {
		p.nextClicked();
		p.changeAutomatCellState(0, 0, 0);
		assertEquals(0, p.getEstados()[0][0]);
		p.changeAutomatCellState(0, 0, 1);
		assertEquals(1, p.getEstados()[0][0]);

		Mockito.verify(v, Mockito.times(3)).update(p, null);
	}
	
	@Test
	public void testaUpdateView() {
		p.updateView(v);

		Mockito.verify(v, Mockito.times(1)).resizeBoardSizeInCellsTo(Mockito.anyInt(), Mockito.anyInt());
		Mockito.verify(v, Mockito.times(100)).changeCell(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt());
	}

}
