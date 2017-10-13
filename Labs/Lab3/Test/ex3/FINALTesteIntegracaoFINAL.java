package ex3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * Ao escolher uma língua, automaticamente, sem nenhuma outra configuração,
 * todas as partes do modelo serão geradas já traduzidas e no formato
 * correto para a língua escolhida.
 * 
 * COMENTÁRIOS: Utilizou-se a classe Modelo responsável pelo layout e a classe
 * Idioma responsável pela tradução de cada campo.
 */
public class FINALTesteIntegracaoFINAL {
	
	private Carta carta;
	private Modelo modelo;
	private Idioma idioma;
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
	public void testaModeloComercialBRPortugues() {
		modelo = new ModeloComercialBR();
		idioma = new Portugues();
		
		carta = new Carta(remetente, destinatario, data, idioma, modelo);
		
		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8B 241, São José dos Campos, SP, Brasil, 1 de 10 de 2017\n\n" + 
				"Caro Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Atensiosamente,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+(55) (012) 3947-7891"
				, carta.lerCarta());
	}


	@Test
	public void testaModeloComercialBRIngles() {
		modelo = new ModeloComercialBR();
		idioma = new Ingles();
		
		carta = new Carta(remetente, destinatario, data, idioma, modelo);
		
		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8B 241, São José dos Campos   SP Brasil, 10/1/2017\n\n" +
				"Dear Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+55 (0) (12) 394-77891"
				, carta.lerCarta());
	}


	@Test
	public void testaModeloComercialUSAIngles() {
		modelo = new ModeloComercialUSA();
		idioma = new Ingles();
		
		carta = new Carta(remetente, destinatario, data, idioma, modelo);
		
		assertEquals(
				"10/1/2017\n" + 
				"\n" + 
				"Gabriel\n" + 
				"H8B 241, São José dos Campos   SP Brasil\n" + 
				"\n" + 
				"Dylan\n" + 
				"H8B 205, São José   SP Brasil\n" + 
				"\n" + 
				"\n" + 
				"Dear Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"\n" + 
				"\n" + 
				"Gabriel\n" + 
				"\n" + 
				"            __________________\n" + 
				"            \n" + 
				"            +55 (0) (12) 394-77891\n" + 
				"            email: gaadrime.melo@gmail.com"
				, carta.lerCarta());
	}

}
