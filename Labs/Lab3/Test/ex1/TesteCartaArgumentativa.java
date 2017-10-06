package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteCartaArgumentativa {
	
	@Mock private Pessoa reme;
	@Mock private Pessoa dest;
	@Mock private Data dia;
	
	private CartaArgumentativa carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaArgumentativa(reme, dest, dia);
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
				"Senhor Dylan, \n" + 
				"\n" + 
				"Seremos\n" + 
				"A ligeira raposa marron correu.\n" + 
				"Fomos\n" + 
				"\n" + 
				"Até breve\n" + 
				"\n" + 
				"Gabriel\n" + 
				"\n"
				, carta.modeloPortugues("Senhor", "Seremos", "A ligeira raposa marron correu.", "Fomos", "Até breve"));
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getEndereco()).thenReturn("H8-B 241");
		Mockito.when(reme.getNome()).thenReturn("Gabriel");
		
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(dia.getDataPortugues(Mockito.anyString())).thenReturn("01 de Outubro de 2017");
	}

}
