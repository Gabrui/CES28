package ex3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Teste de unidade da CartaComercial
 */
public class TesteCartaComercialBR {
	
	@Mock private Pessoa remetente;
	@Mock private Pessoa destinatario;
	@Mock private Data data;
	@Mock private Idioma idioma;
	
	private ModeloComercialBR modelo;
	

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		modelo = new ModeloComercialBR();
	}
	

	@Test
	public void construcaoDaCarta() {
		assertNotNull(modelo);
	}
	
	@Test
	public void testaCabecario() {
		Mockito.when(remetente.getEndereco(Mockito.any())).thenReturn("H8-B 241");
		Mockito.when(remetente.getDepartamento()).thenReturn("Engenharia de Software");
		Mockito.when(remetente.getNomeEmpresa()).thenReturn("ITA");
		Mockito.when(idioma.data(Mockito.any())).thenReturn("01 de Outubro de 2017");
		
		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8-B 241, 01 de Outubro de 2017\n\n"
				, modelo.cabecalho(remetente, destinatario, data, idioma));
	}
	

}
