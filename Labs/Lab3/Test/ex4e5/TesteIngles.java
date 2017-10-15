package ex4e5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ex4e5.Data;
import ex4e5.Endereco;
import ex4e5.Idioma;
import ex4e5.Ingles;
import ex4e5.Telefone;

/**
 * Teste de unidade, com stubs.
 *
 */
public class TesteIngles {
	
	private Idioma ingles;
	@Mock private Data hoje;
	@Mock private Telefone telefone;
	@Mock private Endereco endereco;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ingles = new Idioma.Builder(Ingles.INSTANCE).build();
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(ingles);
	}
	
	@Test
	public void testaSingleton() {
		assertNotNull(Ingles.INSTANCE);
	}
	
	@Test
	public void testa() {
		Mockito.when(telefone.getCC()).thenReturn("23");
	}
	
	@Test
	public void testaStringsConstantes() {
		
		assertEquals("Gratefully", ingles.despedida());
		assertEquals("Dear", ingles.vocativo());
		assertEquals("Mr.", ingles.pronome());
	}
	
	@Test
	public void testaData() {
		Mockito.when(hoje.getDia()).thenReturn("1");
		Mockito.when(hoje.getMes()).thenReturn("10");
		Mockito.when(hoje.getAno()).thenReturn("2017");
		assertEquals("10/1/2017", ingles.data(hoje.getDia(),hoje.getMes(),hoje.getAno()));
	}
	
	@Test
	public void testaEndereco() {
		Mockito.when(endereco.getRua()).thenReturn("Rua");
		Mockito.when(endereco.getCidade()).thenReturn("Cidade");
		Mockito.when(endereco.getEstado()).thenReturn("Estado");
		Mockito.when(endereco.getPais()).thenReturn("Pais");
		assertEquals("Rua, Cidade   Estado Pais", ingles.endereco(endereco.getRua(),endereco.getCidade(),endereco.getEstado(),endereco.getPais()));
	}
	
	@Test
	public void testaFone() {
		int separador = 5;
		Mockito.when(telefone.getDDI()).thenReturn("23");
		Mockito.when(telefone.getCC()).thenReturn("6");
		Mockito.when(telefone.getLC()).thenReturn("79");
		Mockito.when(telefone.getTel(5)).thenReturn("333-12345");
		assertEquals("+23 (6) (79) 333-12345", ingles.fone(telefone.getDDI(),telefone.getCC(),telefone.getLC(),telefone.getTel(separador)));
	}
}
