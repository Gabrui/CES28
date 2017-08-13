package RefatoracaoPersonProject.testes;

import static org.junit.Assert.*;

import org.junit.*;
import RefatoracaoPersonProject.v1.*;

public class TesteProject {
	
	Person p1;
	Person p2;
	Person p3;
	Person p4;
	Person p5;
	Person p6;
	Project t1;
	Project t2;
	
	@Before
	public void inicializa() {
		p1 = new Person();
		p2 = new Person();
		p3 = new Person();
		p4 = new Person();
		p5 = new Person();
		p6 = new Person();
		t1 = new Project();
		t2 = new Project();
	}
	
	@Test
	public void ProjetosContemPessoasQueContem() {
		t1.addParticipant(p1);
		t1.addParticipant(p4);
		t2.addParticipant(p2);
		t2.addParticipant(p3);
		t2.addParticipant(p6);
		assertTrue(t1.hasParticipante(p1));
		assertTrue(t1.hasParticipante(p4));
		assertTrue(t2.hasParticipante(p2));
		assertTrue(t2.hasParticipante(p3));
		assertTrue(t2.hasParticipante(p6));
	}
	
	@Test
	public void ProjetosNaoContemPessoasQueNaoContem() {
		t1.addParticipant(p1);
		t1.addParticipant(p4);
		t2.addParticipant(p2);
		t2.addParticipant(p3);
		t2.addParticipant(p6);
		assertFalse(t1.hasParticipante(p6));
		assertFalse(t1.hasParticipante(p2));
		assertFalse(t2.hasParticipante(p1));
		assertFalse(t2.hasParticipante(p4));
		assertFalse(t2.hasParticipante(p5));
	}
	
	@Test
	public void ProjetosVaziosTemTamanhoZero() {
		assertEquals(t1.getNumberOfParticipants(), 0);
		assertEquals(t2.getNumberOfParticipants(), 0);
	}
	
	@Test
	public void ProjetosUnitariosTemTamanhoUm() {
		t1.addParticipant(p1);
		t2.addParticipant(p2);
		assertEquals(t1.getNumberOfParticipants(), 1);
		assertEquals(t2.getNumberOfParticipants(), 1);
	}
	
	@Test
	public void ProjetosComNumUsuariosTemTamanhoNum() {
		t1.addParticipant(p1);
		t1.addParticipant(p4);
		t2.addParticipant(p2);
		t2.addParticipant(p3);
		t2.addParticipant(p6);
		assertEquals(t1.getNumberOfParticipants(), 2);
		assertEquals(t2.getNumberOfParticipants(), 3);
	}
	
	@Test
	public void ProjetosComAsMesmasPessoasSaoIguais() {
		t1.addParticipant(p1);
		t2.addParticipant(p1);
		t1.addParticipant(p2);
		t2.addParticipant(p2);
		assertEquals(t1, t2);
	}
	
	@Test
	public void ProjetosComPessoasDiferentesSaoDiferentes() {
		t1.addParticipant(p1);
		t2.addParticipant(p6);
		t1.addParticipant(p2);
		t2.addParticipant(p2);
		assertNotEquals(t1, t2);
	}
	
	@Test
	public void ProjetoComUmaPessoaTemEssaPessoa() {
		t1.addParticipant(p1);
		t2.addParticipant(p2);
		assertEquals(t1.getParticipants().elementAt(0), p1);
		assertEquals(t2.getParticipants().elementAt(0), p2);
	}
	
	@Test
	public void ProjetosRetornamStringsCorretamente() {
		t1.addParticipant(p1);
		assertEquals("Project has no person", t2.toString());
		assertEquals("Project has person(s): "+p1.getId()+", ", t1.toString());
	}
	
}
