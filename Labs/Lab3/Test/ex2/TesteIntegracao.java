package ex2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteIntegracao {
	
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
		
		comercial = new CartaComercial(remetente, destinatario, hoje, portugues);
		pessoal = new CartaPessoal(remetente, destinatario, hoje, portugues);
		argumentativa = new CartaArgumentativa(remetente, destinatario, hoje, portugues);
		anonima = new CartaAnonima(destinatario, hoje, portugues);
	}

	@Test
	public void testaConstrucoes() {
		assertNotNull(enderecoDestinatario);
		assertNotNull(enderecoRemetente);
		assertNotNull(destinatario);
		assertNotNull(remetente);
		
		assertNotNull(comercial);
		assertNotNull(pessoal);
		assertNotNull(argumentativa);
		assertNotNull(anonima);
	}
	
	@Test
	public void testaModeloAnonimoPortugues() {
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
				"            +55 (0)  (12) 394-77891\n" + 
				"            email:gaadrime.melo@gmail.com",
				comercial.modelo());
	}
	
	@Test
	public void testaModeloPessoal() {
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

}
