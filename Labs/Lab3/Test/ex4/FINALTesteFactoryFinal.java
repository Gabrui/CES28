package ex4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FINALTesteFactoryFinal {
	

	private FactoryCarta fabrica;
	
	private Pessoa destinatario;
	private Pessoa remetente;
	
	private Data data = new Data(1, "10", 2017);
	private Endereco enderecoDestinatario;
	private Endereco enderecoRemetente;
	
	private Telefone fone = new Telefone(55, 0, 12, 39477891);

	@Before
	public void setUp() {
		enderecoRemetente = new Endereco("H8B 241", "São José dos Campos", "SP", "Brasil");
		enderecoDestinatario = new Endereco("H8B 205", "São José", "SP", "Brasil");
		remetente = new Pessoa.PessoaBuilder("Gabriel", enderecoRemetente).departamento("Pesquisa")
				.emprego("Desenvolvedor").departamento("Engenharia de Software")
				.email("gaadrime.melo@gmail.com").fone(fone).idade(20).nomeEmpresa("ITA").build();
		destinatario = new Pessoa.PessoaBuilder("Dylan", enderecoDestinatario).build();
	}
	
	@Test
	public void testaModeloAutomaticoAoSelecionarIdioma() {
		// A string pt_BR seleciona tanto o idioma quanto o modelo da carta
		fabrica = new FactoryCarta(remetente, destinatario, data, "pt_BR");
		String resultado = fabrica.buildCartaComercial().lerCarta();
		
		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8B 241, São José dos Campos, SP - Brasil, 1 de 10 de 2017\n" + 
				"\n" + 
				"Caro Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+55 - 0 - (12) 39477891",
				resultado);
	}
	

	
	@Test
	public void testaModeloDiferenteDoIdioma() {
		// A string pt_BR seleciona apenas o modelo, já os campos serão em Inglês
		fabrica = new FactoryCarta(remetente, destinatario, data, "pt_BR", Ingles.INSTANCE);
		String resultado = fabrica.buildCartaComercial().lerCarta();
		
		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8B 241, São José dos Campos   SP Brasil, 10/1/2017\n" + 
				"\n" + 
				"Dear Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+55 (0) (12) 39477891",
				resultado);
	}
	
	

	@Test
	public void testaModeloDiferenteDoIdiomaNovo() {
		// A string pt_BR seleciona apenas o modelo, já os campos serão uma mistureba
		Idioma novo = new Idioma.Builder(Ingles.INSTANCE).despedida(Portugues.INSTANCE).build();
		fabrica = new FactoryCarta(remetente, destinatario, data, "pt_BR", novo);
		String resultado = fabrica.buildCartaComercial().lerCarta();
		
		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8B 241, São José dos Campos   SP Brasil, 10/1/2017\n" + 
				"\n" + 
				"Dear Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + // Aqui está a mudança da despedida
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+55 (0) (12) 39477891",
				resultado);
	}
}
