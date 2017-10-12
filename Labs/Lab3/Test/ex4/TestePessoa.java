package ex4;

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
	@Mock private Ingles ing;
	@Mock private Idioma.Builder Ibuilder;
	private Pessoa pessoa;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco).idade(20).emprego("Dev").build();
		Mockito.when(ing.rebuild(Mockito.any())).thenReturn(ing);
		idioma = new Idioma.Builder(Ingles.INSTANCE).build();
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
		Mockito.when(endereco.getRua()).thenReturn("H8");
		Mockito.when(endereco.getCidade()).thenReturn("SJC");
		Mockito.when(endereco.getEstado()).thenReturn("SP");
		Mockito.when(endereco.getPais()).thenReturn("BR");
		Mockito.when(ing.enderecoFormato("H8","SJC","SP","BR")).thenReturn("H8");
		assertEquals("H8, SJC   SP BR", pessoa.getEndereco(idioma));
	}
	
	@Test
	public void testaConstrucaoComplexa() {
		pessoa = new Pessoa.PessoaBuilder("Gabriel", endereco)
				.departamento("Desenvolvimento").email("gaadrime.melo@gmail.com")
				.emprego("Dev").fone(fone).idade(20).nomeEmpresa("ITA").build();
	
		int separador = 5;
		Mockito.when(fone.getDDI()).thenReturn("23");
		Mockito.when(fone.getCC()).thenReturn("6");
		Mockito.when(fone.getLC()).thenReturn("79");
		Mockito.when(fone.getTel(5)).thenReturn("333-12345");
		
		assertNotNull(fone.getDDI());
		assertNotNull(fone.getLC());
		assertNotNull(fone.getCC());
		assertNotNull(fone.getTel(separador));
		assertNotNull(idioma.fone(fone.getDDI(),fone.getCC(),fone.getLC(),fone.getTel(separador)));
		
		assertNotNull(fone.getDDI());
		assertNotNull(fone.getLC());
		assertNotNull(fone.getCC());
		assertNotNull(fone.getTel(separador));
		assertNotNull(idioma.fone(fone.getDDI(),fone.getCC(),fone.getLC(),fone.getTel(separador)));
		
		assertNotNull(pessoa);
		assertEquals("Desenvolvimento", pessoa.getDepartamento());
		assertEquals("gaadrime.melo@gmail.com", pessoa.getEmail());
		assertEquals("Dev", pessoa.getEmprego());
		assertEquals("+23 (6) (79) 3947-7891", pessoa.getFone(idioma));
		assertEquals(20, pessoa.getIdade());
		assertEquals("ITA", pessoa.getNomeEmpresa());
	}

}
