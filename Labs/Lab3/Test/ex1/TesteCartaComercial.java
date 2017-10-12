package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Teste de unidade da CartaComercial
 */
public class TesteCartaComercial {
	
	@Mock private Pessoa reme;
	@Mock private Pessoa dest;
	@Mock private Data dia;
	
	private Carta carta;
	

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
				"ITA\n" + 
				"Gabriel\n" + 
				"H8-B 241\n" + 
				"\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8-B 205\n" + 
				"\n" + 
				"\n" + 
				"Prezado senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"            __________________\n" + 
				"            Gabriel\n" + 
				"            Desenvolvedor\n" + 
				"            3947-7891\n" + 
				"            email:testes@ita.br"
				, carta.modelo());
				
	}
	
	private void valoresPadroesMocks() {
		Mockito.when(reme.getEmprego()).thenReturn("Desenvolvedor");
		Mockito.when(reme.getEmail()).thenReturn("testes@ita.br");
		Mockito.when(reme.getEndereco()).thenReturn("H8-B 241");
		Mockito.when(reme.getFone()).thenReturn("3947-7891");
		Mockito.when(reme.getNome()).thenReturn("Gabriel");
		Mockito.when(reme.getNomeEmpresa()).thenReturn("ITA");
		
		Mockito.when(dest.getEndereco()).thenReturn("H8-B 205");
		Mockito.when(dest.getNome()).thenReturn("Dylan");

		Mockito.when(dia.toString()).thenReturn("01/10/2017");
	}

}
