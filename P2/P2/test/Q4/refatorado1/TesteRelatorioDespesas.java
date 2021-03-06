package Q4.refatorado1;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteRelatorioDespesas {
	
	private @Mock Imprime impri;
	
	
	private @InjectMocks RelatorioDespesas relaInjetado; // Implementação EXTRA, não necessária
	private @Mock Despesa desp;
	private @Mock Calculadora calc;

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
	
	
///////////////////////////////// OBS: TESTES DE UMA IMPLEMENTAÇÂO EXTRA
	@Test
	public void testaImpressaoComplexaNula() {
		LinkedList<Despesa> lista= new LinkedList<>();
		Mockito.when(calc.calculaDespesas(Mockito.any())).thenReturn(0.0f);
		relaInjetado.imprimirRelatorio(lista.iterator(), impri);
		
		// Verifica o comportamento de impri, mock:
		Mockito.verify(impri, Mockito.times(1)).imprimir(
						Mockito.eq("Relatório de Despesas\n Total das despesas: 0.0"));
	}
	
	@Test
	public void testaImpressaoComplexa() {
		LinkedList<Despesa> lista= new LinkedList<>();
		Mockito.when(desp.getDespesa()).thenReturn(5.0f);
		lista.add(desp);
		Mockito.when(calc.calculaDespesas(Mockito.any())).thenReturn(5.0f);
		relaInjetado.imprimirRelatorio(lista.iterator(), impri);
		
		//Mockito.verify(calc, Mockito.times(1)).calculaDespesas(Mockito.any());
		// Verifica o comportamento de impri, mock:
		Mockito.verify(impri, Mockito.times(1)).imprimir(
						Mockito.eq("Relatório de Despesas\n Total das despesas: 5.0"));
	}

}
