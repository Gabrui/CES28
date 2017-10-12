package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Teste de unidade da CartaPessoal
 */
public class TesteCartaPessoal {
	
	@Mock private Pessoa reme;
	@Mock private Pessoa dest;
	@Mock private Data dia;
	
	private Carta carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaPessoal(reme, dest, dia);
	}
	

	@Test
	public void construcaoDaCarta() {
		assertNotNull(carta);
	}
	
	@Test
	public void testaModeloPortuguês() {
		valoresPadroesMocks();
		assertEquals(
				"H8\n" + 
				"01 de Outubro de 2017\n" + 
				"\n" + 
				"Caro Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel"
				, carta.modelo());
				
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getNome()).thenReturn("Gabriel");
		
		Mockito.when(dest.getNome()).thenReturn("Dylan");
		Mockito.when(dest.getEndereco()).thenReturn("H8");

		Mockito.when(dia.toString()).thenReturn("01 de Outubro de 2017");
	}

}
