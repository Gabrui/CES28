package ex2;

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
	@Mock private Idioma idioma;
	
	private CartaPessoal carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaPessoal(reme, dest, dia, idioma);
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
				"01 de Outubro de 2017\n" + 
				"\n" + 
				"Amigo Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Até breve,\n" + 
				"Gabriel"
				, carta.modelo());
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getNome()).thenReturn("Gabriel");

		Mockito.when(dest.getEndereco(Mockito.any())).thenReturn("H8-B 208");
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(idioma.data(Mockito.any())).thenReturn("01 de Outubro de 2017");
		Mockito.when(idioma.despedida()).thenReturn("Até breve");
		Mockito.when(idioma.pronome()).thenReturn("Amigo");
		
		
	}
}
