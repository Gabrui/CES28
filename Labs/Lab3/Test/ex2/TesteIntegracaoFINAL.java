package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Testa a integração de todas as classes concretas do Ex2
 * 
 * COMENTÁRIOS:
 * 
 * A carta agora também recebe um Idioma na sua construção. Esse idioma é responsável
 * por formatar cada campo da forma solicitada.
 * 
 * 
 * => Idioma: Essa classe é responsável pela formação de cada campo da carta.
 * 
 * É extremamente fácil de ser extendida, bastando o programador criar
 * uma nova classe que a extenda ou uma de suas subclasses, sem a necessidade
 * de se alterar nenhuma outra classe.
 * 
 * Ou seja, o código está aberto para extensão mas fechado para modificação, 
 * digamos, se fosse necessário alterar o código interno de alguma classe concreta
 * já existente.
 * 
 * Uma atenção especial foi dada também ao fato de não existirem classes anêmicas, 
 * com apenas um método, o que é um mal-cheiro, dessa forma as traduções dos campos
 * foram agrupados nessa classe idioma, em vez de existirem várias classes pequenas
 * para cada campo.
 * 
 * Assim, nesse primeiro momento, utilizou-se apenas uma simples herança de idiomas
 * e injeção de dependência em carta para se obter o requisito de cartas em diferentes
 * idiomas, pois esse foi a forma mais simples para extensão encontrada. Em uma 
 * AbstractFactory convencional o usuário precisaria extender tanto os produtos (campos)
 * quanto a factory (Idioma), o que seria mais trabalhoso, e ainda poderiam existir
 * classes anêmicas.
 */
public class TesteIntegracaoFINAL {
	
	private Carta comercial;
	private Carta pessoal;
	private Carta argumentativa;
	private Carta anonima;
	
	private Endereco enderecoDestinatario;
	private Endereco enderecoRemetente;
	
	private Pessoa destinatario;
	private Pessoa remetente;
	
	private Data hoje = new Data(1, "10", 2017);
	private Telefone fone = new Telefone(55, 0, 12, 39477891);
	private Idioma portugues = new Portugues();
	private Idioma ingles = new Ingles();

	
	@Before
	public void setUp() {
		
		enderecoRemetente = new Endereco("H8B 241", "São José dos Campos", "SP", "Brasil");
		enderecoDestinatario = new Endereco("H8B 205", "São José", "SP", "Brasil");
		
		remetente = new Pessoa.PessoaBuilder("Gabriel", enderecoRemetente).departamento("Pesquisa")
				.emprego("Desenvolvedor")
				.email("gaadrime.melo@gmail.com").fone(fone).idade(20).nomeEmpresa("ITA").build();
		destinatario = new Pessoa.PessoaBuilder("Dylan", enderecoDestinatario).build();
	}

	@Test
	public void testaConstrucoes() {
		assertNotNull(enderecoDestinatario);
		assertNotNull(enderecoRemetente);
		assertNotNull(destinatario);
		assertNotNull(remetente);

		anonima = new CartaAnonima(destinatario, hoje, portugues);
		argumentativa = new CartaArgumentativa(remetente, destinatario, hoje, portugues);
		comercial = new CartaComercial(remetente, destinatario, hoje, portugues);
		pessoal = new CartaPessoal(remetente, destinatario, hoje, portugues);
		
		assertNotNull(comercial);
		assertNotNull(pessoal);
		assertNotNull(argumentativa);
		assertNotNull(anonima);
	}
	
	@Test
	public void testaModeloAnonimoPortugues() {
		anonima = new CartaAnonima(destinatario, hoje, portugues);
		assertEquals(
				"H8B 205, São José, SP, Brasil\n" + 
				"1 de 10 de 2017\n" + 
				"\n" + 
				"Senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente.",
				anonima.modelo());
	}
	
	@Test
	public void testaModeloArgumentativoPortugues() {
		argumentativa = new CartaArgumentativa(remetente, destinatario, hoje, portugues);
		assertEquals(
				"Gabriel\n" + 
				"H8B 241, São José dos Campos, SP, Brasil\n" + 
				"\n" + 
				"1 de 10 de 2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José, SP, Brasil\n" + 
				"\n" + 
				"\n" + 
				"Senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel",
				argumentativa.modelo());
	}
	
	@Test
	public void testaModeloComercialPortugues() {
		comercial = new CartaComercial(remetente, destinatario, hoje, portugues);
		assertEquals(
				"ITA\n" + 
				"Gabriel\n" + 
				"H8B 241, São José dos Campos, SP, Brasil\n" + 
				"\n" + 
				"1 de 10 de 2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José, SP, Brasil\n" + 
				"\n" + 
				"\n" + 
				"Senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"            __________________\n" + 
				"            Gabriel\n" + 
				"            Desenvolvedor\n" + 
				"            +(55) (012) 3947-7891\n" + 
				"            email:gaadrime.melo@gmail.com",
				comercial.modelo());
	}
	
	@Test
	public void testaModeloPessoalPortugues() {
		pessoal = new CartaPessoal(remetente, destinatario, hoje, portugues);
		assertEquals(
				"H8B 205, São José, SP, Brasil\n" + 
				"1 de 10 de 2017\n" + 
				"\n" + 
				"Senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel",
				pessoal.modelo());
	}
	

	
	@Test
	public void testaModeloAnonimoIngles() {
		anonima = new CartaAnonima(destinatario, hoje, ingles);
		assertEquals(
				"H8B 205, São José   SP Brasil\n" + 
				"10/1/2017\n" + 
				"\n" + 
				"Mr. Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Gratefully.",
				anonima.modelo());
	}
	
	@Test
	public void testaModeloArgumentativoIngles() {
		argumentativa = new CartaArgumentativa(remetente, destinatario, hoje, ingles);
		assertEquals(
				"Gabriel\n" + 
				"H8B 241, São José dos Campos   SP Brasil\n" + 
				"\n" + 
				"10/1/2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José   SP Brasil\n" + 
				"\n" + 
				"\n" + 
				"Mr. Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"Gabriel",
				argumentativa.modelo());
	}
	
	@Test
	public void testaModeloComercialIngles() {
		comercial = new CartaComercial(remetente, destinatario, hoje, ingles);
		assertEquals(
				"ITA\n" + 
				"Gabriel\n" + 
				"H8B 241, São José dos Campos   SP Brasil\n" + 
				"\n" + 
				"10/1/2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José   SP Brasil\n" + 
				"\n" + 
				"\n" + 
				"Mr. Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"            __________________\n" + 
				"            Gabriel\n" + 
				"            Desenvolvedor\n" + 
				"            +55 (0) (12) 394-77891\n" + 
				"            email:gaadrime.melo@gmail.com",
				comercial.modelo());
	}
	
	@Test
	public void testaModeloPessoalIngles() {
		pessoal = new CartaPessoal(remetente, destinatario, hoje, ingles);
		assertEquals(
				"H8B 205, São José   SP Brasil\n" + 
				"10/1/2017\n" + 
				"\n" + 
				"Mr. Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"Gabriel",
				pessoal.modelo());
	}

}
