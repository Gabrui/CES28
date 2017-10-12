package ex4;

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
	
}
