package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteCartaPessoal {
	
	@Mock private Pessoa reme;
	@Mock private Pessoa dest;
	@Mock private Data dia;
	
	private CartaPessoal carta;
	

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
				"H8-B 241, 01 de Outubro de 2017\n" + 
				"\n" + 
				"Amigo Dylan, \n" + 
				"\n" + 
				"A ligeira raposa marron correu.\n" + 
				"\n" + 
				"Até breve\n" + 
				"\n" + 
				"Gabriel\n" + 
				"\n"
				, carta.modeloPortugues("Amigo", "A ligeira raposa marron correu.", "Até breve"));
				
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getEndereco()).thenReturn("H8-B 241");
		Mockito.when(reme.getNome()).thenReturn("Gabriel");
		
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(dia.getDataPortugues(Mockito.anyString())).thenReturn("01 de Outubro de 2017");
	}

}
