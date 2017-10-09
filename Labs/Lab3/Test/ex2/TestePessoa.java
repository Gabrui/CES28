package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestePessoa {
	
	@Mock private Endereco endereco;
	@Mock private Telefone fone;
	@Mock private Idioma idioma;
	private Pessoa pessoa;
	private Pessoa anom;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		anom = new Pessoa.PessoaBuilder().build();
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco).idade(20).emprego("Dev").build();
	}

	@Test
	public void testaInicializacao() {
		assertNotNull(anom);
		assertNotNull(pessoa);
	}
	
	@Test
	public void testaNome() {
		assertEquals("Anônimo", anom.getNome());
		assertEquals("Gabriel", pessoa.getNome());
	}
	
	@Test
	public void testaEndereco() {
		Mockito.when(idioma.endereco(endereco)).thenReturn("H8");
		assertEquals("H8", pessoa.getEndereco(idioma));
	}
	
	@Test
	public void testaConstrucaoComplexa() {
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco)
				.departamento("Desenvolvimento").email("gaadrime.melo@gmail.com")
				.emprego("Dev").fone(fone).idade(20).nomeEmpresa("ITA").build();
		Mockito.when(idioma.fone(fone)).thenReturn("3947-7891");
		assertNotNull(pessoa);
		assertEquals("Desenvolvimento", pessoa.getDepartamento());
		assertEquals("gaadrime.melo@gmail.com", pessoa.getEmail());
		assertEquals("Dev", pessoa.getEmprego());
		assertEquals("3947-7891", pessoa.getFone(idioma));
		assertEquals(20, pessoa.getIdade());
		assertEquals("ITA", pessoa.getNomeEmpresa());
	}

}
