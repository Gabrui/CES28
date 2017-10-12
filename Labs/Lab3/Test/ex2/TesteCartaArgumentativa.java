package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Teste de unidade da CartaArgumentativa
 */
public class TesteCartaArgumentativa {
	
	@Mock private Pessoa reme;
	@Mock private Pessoa dest;
	@Mock private Data dia;
	@Mock private Idioma idioma;
	
	private CartaArgumentativa carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaArgumentativa(reme, dest, dia, idioma);
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
				"01 de Outubro de 2017\n" + 
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
		Mockito.when(reme.getEndereco(Mockito.any())).thenReturn("H8-B 241");
		Mockito.when(reme.getNome()).thenReturn("Gabriel");

		Mockito.when(dest.getEndereco(Mockito.any())).thenReturn("H8-B 208");
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(idioma.data(Mockito.any())).thenReturn("01 de Outubro de 2017");
		Mockito.when(idioma.despedida()).thenReturn("Atensiosamente");
		Mockito.when(idioma.pronome()).thenReturn("Caro");
		
		
	}

}
