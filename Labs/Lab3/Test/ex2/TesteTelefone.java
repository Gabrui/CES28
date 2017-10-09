package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteTelefone {
	
	private Telefone tel;

	@Before
	public void setUp() {
		tel = new Telefone(55, 0, 12, 39477891);
	}

	@Test
	public void testaConstrutor() {
		assertNotNull(tel);
	}
	
	@Test
	public void testaGetDDI() {
		assertEquals("55", tel.DDI());
	}

	@Test
	public void testaGetCC() {
		assertEquals("0", tel.cc());
	}

	@Test
	public void testaGetLC() {
		assertEquals("12", tel.lc());
	}
	

	@Test
	public void testaGetTel() {
		assertEquals("39477891", tel.tel());
	}

	@Test
	public void testaGetTelSeparador() {
		assertEquals("394-77891", tel.tel(5));
		assertEquals("3947-7891", tel.tel(4));
		assertEquals("39477-891", tel.tel(3));
	}
}
