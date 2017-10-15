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
import ex4e5.Portugues;
import ex4e5.Telefone;

/**
 * Teste de unidade, com stubs.
 *
 */
public class TestePortugues {
	
	private Idioma portugues;
	@Mock private Data hoje;
	@Mock private Telefone telefone;
	@Mock private Endereco endereco;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		portugues =new Idioma.Builder(Portugues.INSTANCE).build();
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(portugues);
	}
	
	@Test
	public void testaStringsConstantes() {
		assertEquals("Atensiosamente", portugues.despedida());
		assertEquals("Caro", portugues.vocativo());
		assertEquals("Senhor", portugues.pronome());
	}
	
	@Test
	public void testaData() {
		Mockito.when(hoje.getDia()).thenReturn("1");
		Mockito.when(hoje.getMes()).thenReturn("10");
		Mockito.when(hoje.getAno()).thenReturn("2017");
		assertEquals("1 de 10 de 2017", portugues.data(hoje.getDia(),hoje.getMes(),hoje.getAno()));
	}
	
	@Test
	public void testaEndereco() {
		Mockito.when(endereco.getRua()).thenReturn("Rua");
		Mockito.when(endereco.getCidade()).thenReturn("Cidade");
		Mockito.when(endereco.getEstado()).thenReturn("Estado");
		Mockito.when(endereco.getPais()).thenReturn("Pais");
		assertEquals("Rua, Cidade, Estado - Pais", portugues.endereco(endereco.getRua(),endereco.getCidade(),endereco.getEstado(),endereco.getPais()));
	}
	
	@Test
	public void testaFone() {
		int separador = 4;
		Mockito.when(telefone.getDDI()).thenReturn("55");
		Mockito.when(telefone.getCC()).thenReturn("0");
		Mockito.when(telefone.getLC()).thenReturn("12");
		Mockito.when(telefone.getTel(4)).thenReturn("3947-7891");
		assertEquals("+55 - 0 - (12) 3947-7891", portugues.fone(telefone.getDDI(),telefone.getCC(),telefone.getLC(),telefone.getTel(separador)));
	}
	
}
