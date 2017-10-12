package ex1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Teste de unidade de Pessoa
 */
public class TestePessoa {
	
	@Mock private Endereco endereco;
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
	public void testaEndereco() {
		Mockito.when(endereco.getEndereco()).thenReturn("H8");
		assertEquals(endereco.getEndereco(), pessoa.getEndereco());
	}
	
	@Test
	public void testaConstrucaoComplexa() {
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco)
				.departamento("Desenvolvimento").email("gaadrime.melo@gmail.com")
				.emprego("Dev").fone("3947-7891").idade(20).nomeEmpresa("ITA").build();
		assertNotNull(pessoa);
		assertEquals("Desenvolvimento", pessoa.getDepartamento());
		assertEquals("gaadrime.melo@gmail.com", pessoa.getEmail());
		assertEquals("Dev", pessoa.getEmprego());
		assertEquals("3947-7891", pessoa.getFone());
		assertEquals(20, pessoa.getIdade());
		assertEquals("ITA", pessoa.getNomeEmpresa());
	}

}
