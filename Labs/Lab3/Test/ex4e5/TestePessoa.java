package ex4e5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ex4e5.Endereco;
import ex4e5.Idioma;
import ex4e5.Pessoa;
import ex4e5.Telefone;

public class TestePessoa {
	
	@Mock private Endereco endereco;
	@Mock private Telefone fone;
	@Mock private Idioma idioma;
	private Pessoa pessoa;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco).idade(20).emprego("Dev").build();
	}

	@Test
	public void testaInicializacao() {
		assertNotNull(pessoa);
	}
	
	@Test
	public void testaNome() {
		assertEquals("Gabriel", pessoa.getNome());
	}
	
	@Test
	public void testaConstrucaoComplexa() {
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco)
				.departamento("Desenvolvimento").email("gaadrime.melo@gmail.com")
				.emprego("Dev").fone(fone).idade(20).nomeEmpresa("ITA").build();
		assertNotNull(pessoa);
		assertEquals("Desenvolvimento", pessoa.getDepartamento());
		assertEquals("gaadrime.melo@gmail.com", pessoa.getEmail());
		assertEquals("Dev", pessoa.getEmprego());
		assertEquals(20, pessoa.getIdade());
		assertEquals("ITA", pessoa.getNomeEmpresa());
	}

}
