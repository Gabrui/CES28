package ex2;

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
	
	@Mock private Pessoa remetente;
	@Mock private Pessoa destinatario;
	@Mock private Data data;
	@Mock private Idioma idioma;
	
	private CartaComercial carta;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		carta = new CartaComercial(remetente, destinatario, data, idioma);
	}
	

	@Test
	public void construcaoDaCarta() {
		assertNotNull(carta);
	}
	
	@Test
	public void testaModelo() {
		valoresPadroesMocks();
		assertEquals(
				"ITA\n" + 
				"Gabriel\n" + 
				"H8-B 241\n" + 
				"\n" + 
				"01 de Outubro de 2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8-B 208\n" + 
				"\n" + 
				"\n" + 
				"Senhor Dylan,\n" + 
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
		Mockito.when(remetente.getEndereco(Mockito.any())).thenReturn("H8-B 241");
		Mockito.when(remetente.getNome()).thenReturn("Gabriel");
		Mockito.when(remetente.getEmprego()).thenReturn("Desenvolvedor");
		Mockito.when(remetente.getEmail()).thenReturn("testes@ita.br");
		Mockito.when(remetente.getFone(Mockito.any())).thenReturn("3947-7891");
		Mockito.when(remetente.getNomeEmpresa()).thenReturn("ITA");

		Mockito.when(destinatario.getEndereco(Mockito.any())).thenReturn("H8-B 208");
		Mockito.when(destinatario.getNome()).thenReturn("Dylan");
		
		Mockito.when(idioma.data(Mockito.any())).thenReturn("01 de Outubro de 2017");
		Mockito.when(idioma.despedida()).thenReturn("Atensiosamente");
		Mockito.when(idioma.pronome()).thenReturn("Senhor");
		
	}

}
