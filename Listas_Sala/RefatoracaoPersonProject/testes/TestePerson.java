package RefatoracaoPersonProject.testes;

import static org.junit.Assert.*;

import org.junit.*;
import RefatoracaoPersonProject.v1.*;

public class TestePerson {
	
	Person p1;
	Person p2;
	Person p3;
	Person p4;
	Person p5;
	Person p6;

	
	@Before
	public void inicializa() {
		p1 = new Person();
		p2 = new Person();
		p3 = new Person();
		p4 = new Person();
		p5 = new Person();
		p6 = new Person();
	}	
	
	@Test
	public void PessoasTemIdsDiferentes() {
		assertFalse(p1.getId() == p2.getId());
		assertFalse(p5.getId() == p3.getId());
		assertFalse(p2.getId() == p4.getId());
		assertFalse(p3.getId() == p6.getId());
		assertFalse(p1.getId() == p5.getId());
		assertFalse(p5.getId() == p2.getId());
		assertFalse(p2.getId() == p3.getId());
		assertFalse(p1.getId() == p4.getId());
	}
	

}
