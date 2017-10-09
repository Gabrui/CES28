package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteEndereco {
	
	private Endereco endereco;

	@Before
	public void setUp() {
		endereco = new Endereco("H8B 241", "São José dos Campos", "SP", "Brasil");
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(endereco);
	}
	
	@Test
	public void testaGetRua() {
		assertEquals("H8B 241", endereco.getRua());
	}
	
	@Test
	public void testaGetCidade() {
		assertEquals("São José dos Campos", endereco.getCidade());
	}
	
	@Test
	public void testaGetEstado() {
		assertEquals("SP", endereco.getEstado());
	}
	
	@Test
	public void testaGetPais() {
		assertEquals("Brasil", endereco.getPais());
	}

}
