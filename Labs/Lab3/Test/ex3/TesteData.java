package ex3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteData {
	
	private Data hoje;

	@Before
	public void setUp() {
		hoje = new Data(1, "10", 2017);
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(hoje);
	}
	
	@Test
	public void testaGetDia() {
		assertEquals("1", hoje.getDia());
	}

	@Test
	public void testaGetMes() {
		assertEquals("10", hoje.getMes());
	}

	@Test
	public void testaGetAno() {
		assertEquals("2017", hoje.getAno());
	}

}
