package ex3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TesteCarta {
	
	@Mock private Pessoa remetente;
	@Mock private Pessoa destinatario;
	@Mock private Data data;
	@Mock private Idioma idioma;
	@Mock private Modelo modelo;
	
	private Carta carta;
	

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		carta = new Carta(remetente, destinatario, data, idioma, modelo);
	}
	

	@Test
	public void construcaoDaCarta() {
		assertNotNull(carta);
	}
	
	@Test
	public void testaModelo() {
		Mockito.when(modelo.cabecario(remetente, destinatario, data, idioma))
			.thenReturn("01 de Outubro de 2017\n\n");
		Mockito.when(modelo.corpo(idioma, destinatario)).thenReturn("Senhor Dylan,\n\n\n");
		Mockito.when(modelo.despedida(idioma)).thenReturn("Atensiosamente,\n");
		Mockito.when(modelo.assinatura(remetente, idioma)).thenReturn("Gabriel");
		assertEquals(
				"01 de Outubro de 2017\n" + 
				"\n" + 
				"Senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel"
				, carta.lerCarta());
	}

}
