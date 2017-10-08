package ex1;

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
	
	private Data hoje;

	
	@Before
	public void setUp() {
		hoje = new Data("01", "10", "2017");
		
		enderecoRemetente = new Endereco("H8B 241", "São José dos Campos", "SP", "Brasil");
		enderecoDestinatario = new Endereco("H8B 205", "São José", "SP", "Brasil");
		
		remetente = new Pessoa.PessoaBuilder("Gabriel", enderecoRemetente).departamento("Pesquisa")
				.email("gaadrime.melo@gmail.com").fone("3947-7891").idade(20).nomeEmpresa("ITA").build();
		destinatario = new Pessoa.PessoaBuilder("Dylan", enderecoDestinatario).build();
		
		comercial = new CartaComercial(remetente, destinatario, hoje);
		pessoal = new CartaPessoal(remetente, destinatario, hoje);
		argumentativa = new CartaArgumentativa(remetente, destinatario, hoje);
		anonima = new CartaAnonima(destinatario, hoje);
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
	public void testaModeloAnonimo() {
		assertEquals(
				"H8B 205, São José, SP, Brasil\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Caro Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Obrigado.",
				anonima.modelo());
	}
	
	@Test
	public void testaModeloArgumentativo() {
		assertEquals(
				"Gabriel\n" + 
				"H8B 241, São José dos Campos, SP, Brasil\n" + 
				"\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José, SP, Brasil\n" + 
				"\n" + 
				"\n" + 
				"Caro Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel",
				argumentativa.modelo());
	}
	
	@Test
	public void testaModeloComercial() {
		assertEquals(
				"ITA\n" + 
				"Gabriel\n" + 
				"H8B 241, São José dos Campos, SP, Brasil\n" + 
				"\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José, SP, Brasil\n" + 
				"\n" + 
				"\n" + 
				"Prezado senhor Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"            __________________\n" + 
				"            Gabriel\n" + 
				"            \n" + 
				"            3947-7891\n" + 
				"            email:gaadrime.melo@gmail.com",
				comercial.modelo());
	}
	
	@Test
	public void testaModeloPessoal() {
		assertEquals(
				"H8B 205, São José, SP, Brasil\n" + 
				"01/10/2017\n" + 
				"\n" + 
				"Caro Dylan,\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel",
				pessoal.modelo());
	}

}
