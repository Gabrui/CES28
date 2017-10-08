package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteData {
	
	private Data hoje;

	@Before
	public void setUp() {
		hoje = new Data("01", "10", "2017");
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(hoje);
	}
	
	@Test
	public void testaGetDia() {
		assertEquals("01", hoje.getDia());
	}

	@Test
	public void testaGetMes() {
		assertEquals("10", hoje.getMes());
	}

	@Test
	public void testaGetAno() {
		assertEquals("2017", hoje.getAno());
	}

	@Test
	public void testaToString() {
		assertEquals("01/10/2017", hoje.toString());
	}

}
