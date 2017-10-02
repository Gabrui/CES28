package Q4.refatorado1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteRelatorioDespesas {
	
	private @Mock Imprime impri;

	private RelatorioDespesas rela;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		rela = new RelatorioDespesas();
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(rela);
	}
	
	@Test
	public void testaImpressaoNula() {
		rela.imprimirRelatorio(0, impri);
		
		// Verifica o comportamento de impri, mock:
		Mockito.verify(impri, Mockito.times(1)).imprimir(
				Mockito.eq("Relatório de Despesas\n Total das despesas: 0.0"));
	}
	
	@Test
	public void testaImpressaoSimples() {
		rela.imprimirRelatorio(10, impri);
		
		// Verifica o comportamento de impri, mock:
		Mockito.verify(impri, Mockito.times(1)).imprimir(
				Mockito.eq("Relatório de Despesas\n Total das despesas: 10.0"));
	}

}
