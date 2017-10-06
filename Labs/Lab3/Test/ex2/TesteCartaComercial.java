package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteCartaComercial {
	
	@Mock private Pessoa reme;
	@Mock private Pessoa dest;
	@Mock private Data dia;
	
	private CartaComercial carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaComercial(reme, dest, dia);
	}
	

	@Test
	public void construcaoDaCarta() {
		assertNotNull(carta);
	}
	
	@Test
	public void testaModeloPadrao() {
		valoresPadroesMocks();
		assertEquals(
				"01/10/2017\n" + 
				"\n" + 
				"Gabriel\n" + 
				"H8-B 241\n" + 
				"Dylan\n" + 
				"H8-B 208\n" + 
				"\n" + 
				"\n" + 
				"Dear Dylan,\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"\n" + 
				"\n" + 
				"            __________________\n" + 
				"            Gabriel\n" + 
				"            3947-7891\n" + 
				"            email:testes@ita.br"
				, carta.modelo());
	}
	
	@Test
	public void testaModeloPortuguês() {
		valoresPadroesMocks();
		assertEquals(
				"ITA\n" + 
				"Desenvolvimento\n" + 
				"H8-B 241, 01/10/2017\n" + 
				"Assunto: TESTE\n" + 
				"\n" + 
				"CaroDylan: \n" + 
				"\n" + 
				"A ligeira raposa marron correu.\n" + 
				"\n" + 
				"Até breve,\n" + 
				"\n" + 
				"Gabriel\n" + 
				"\n" + 
				"Desenvolvimento"
				, carta.modeloPortugues("TESTE", "Caro", "A ligeira raposa marron correu.", "Até breve"));
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getDepartamento()).thenReturn("Desenvolvimento");
		Mockito.when(reme.getEmail()).thenReturn("testes@ita.br");
		Mockito.when(reme.getEndereco()).thenReturn("H8-B 241");
		Mockito.when(reme.getFone()).thenReturn("3947-7891");
		Mockito.when(reme.getNome()).thenReturn("Gabriel");
		Mockito.when(reme.getNomeEmpresa()).thenReturn("ITA");
		
		Mockito.when(dest.getEndereco()).thenReturn("H8-B 208");
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(dia.toString()).thenReturn("01/10/2017");
		Mockito.when(dia.getDataPortugues(Mockito.anyString())).thenReturn("01/10/2017");
	}

}
