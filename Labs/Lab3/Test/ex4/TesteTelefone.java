package ex4;

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
		assertEquals("55", tel.getDDI());
	}

	@Test
	public void testaGetCC() {
		assertEquals("0", tel.getCC());
	}

	@Test
	public void testaGetLC() {
		assertEquals("12", tel.getLC());
	}
	

	@Test
	public void testaGetTel() {
		assertEquals("39477891", tel.getTel());
	}

	@Test
	public void testaGetTelSeparador() {
		assertEquals("394-77891", tel.getTel(5));
		assertEquals("3947-7891", tel.getTel(4));
		assertEquals("39477-891", tel.getTel(3));
	}
}
