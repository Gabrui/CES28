package ex3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
		ingles = new Ingles();
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(ingles);
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
		assertEquals("10/1/2017", ingles.data(hoje));
	}
	
	@Test
	public void testaEndereco() {
		Mockito.when(endereco.getRua()).thenReturn("Rua");
		Mockito.when(endereco.getCidade()).thenReturn("Cidade");
		Mockito.when(endereco.getEstado()).thenReturn("Estado");
		Mockito.when(endereco.getPais()).thenReturn("Pais");
		assertEquals("Rua, Cidade   Estado Pais", ingles.endereco(endereco));
	}
	
	@Test
	public void testaFone() {
		Mockito.when(telefone.getDDI()).thenReturn("23");
		Mockito.when(telefone.getCC()).thenReturn("6");
		Mockito.when(telefone.getLC()).thenReturn("79");
		Mockito.when(telefone.getTel(5)).thenReturn("333-12345");
		assertEquals("+23 (6) (79) 333-12345", ingles.fone(telefone));
	}
	
}
