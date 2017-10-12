package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Teste de unidade da CartaAnonima
 */
public class TesteCartaAnonima {
	
	@Mock private Pessoa dest;
	@Mock private Data dia;
	
	private Carta carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaAnonima(dest, dia);
	}
	

	@Test
	public void construcaoDaCarta() {
		assertNotNull(carta);
	}
	
	@Test
	public void testaModelo() {
		valoresPadroesMocks();
		assertEquals(
				"H8-B 208\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Caro Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Obrigado."
				, carta.modelo());
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(dest.getEndereco()).thenReturn("H8-B 208");
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(dia.toString()).thenReturn("01/10/2017");
	}

}
