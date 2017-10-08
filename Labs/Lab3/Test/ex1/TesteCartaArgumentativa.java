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
	
	private Carta carta;
	

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
	public void testaModelo() {
		valoresPadroesMocks();
		assertEquals(
				"Gabriel\n" + 
				"H8-B 241\n" + 
				"\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8-B 208\n" + 
				"\n" + 
				"\n" + 
				"Caro Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel"
				, carta.modelo());
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getEndereco()).thenReturn("H8-B 241");
		Mockito.when(reme.getNome()).thenReturn("Gabriel");
		
		Mockito.when(dest.getEndereco()).thenReturn("H8-B 208");
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(dia.toString()).thenReturn("01/10/2017");
	}

}
