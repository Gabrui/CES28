package ex4e5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ex4e5.Data;
import ex4e5.Endereco;
import ex4e5.FactoryCarta;
import ex4e5.Idioma;
import ex4e5.Ingles;
import ex4e5.Pessoa;
import ex4e5.Portugues;
import ex4e5.Telefone;

/**
 * 
 * Ao escolher uma língua, o usuário das classes automaticamente receberá 
 * uma carta comercial no formato correspondente à língua escolhida, não 
 * apenas considerando o formato dos campos (Idioma), mas também a ordenação e 
 * disposição dos campos na página (Modelo).
 * 
 * Utilizou-se uma Factory com dicionários, relacionando a string passada, com um Modelo
 * padrão e um Idioma padrão. Sua extensão é relativamente fácil, sendo necessário apenas
 * a chamada das funções addModelo para associar uma string a um Modelo.
 * 
 * Para a configuração das subpartes dinâmicas, ver o outro teste.
 */
public class FINALTesteFactoryFINAL { // Teste de Integração

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
	
	
	/**
	 * Ao escolher a língua portuguesa para uma carta comercial, por default, 
	 * automaticamente o modelo comercial brasileiro será o usado para gerar 
	 * uma carta comercial com todas as subpartes traduzidas para o portugues. 
	 */
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
	

	/**
	 * Se o programador usuário das classes escolher explicitamente uma língua para o 
	 * modelo é possível gerar o modelo comercial brasileira traduzido para inglês.
	 */
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
	
	
	/**
	 * Pode-se produzir outras combinações de modelos de layout e subpartes 
	 * associados a outras línguas, se indicado explicitamente.
	 */
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
				"Atensiosamente,\n" + // Aqui está a mudança da despedida, em português!
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+55 (0) (12) 39477891",
				resultado);
	}
}
