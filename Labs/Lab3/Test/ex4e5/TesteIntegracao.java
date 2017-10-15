package ex4e5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ex4e5.Carta;
import ex4e5.Data;
import ex4e5.Endereco;
import ex4e5.Idioma;
import ex4e5.Ingles;
import ex4e5.Modelo;
import ex4e5.ModeloComercialBR;
import ex4e5.Pessoa;
import ex4e5.Portugues;
import ex4e5.Telefone;


public class TesteIntegracao {
	
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
		idioma = Portugues.INSTANCE;
		
		carta = new Carta(remetente, destinatario, data, idioma, modelo);
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
				"+55 - 0 - (12) 39477891"
				, carta.lerCarta());
	}


	@Test
	public void testaModeloComercialBRMistureba() {
		modelo = new ModeloComercialBR();
		idioma = new Idioma.Builder(Ingles.INSTANCE).endereco(Portugues.INSTANCE).build();
		// Formato do campo endereço é em Português.
		carta = new Carta(remetente, destinatario, data, idioma, modelo);

		assertEquals(
				"ITA\n" + 
				"Engenharia de Software\n" + 
				"H8B 241, São José dos Campos, SP - Brasil, 10/1/2017\n" + 
				"\n" + 
				"Dear Dylan: \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Gratefully,\n" + 
				"Gabriel\n" + 
				"\n" + 
				"Engenharia de Software\n" + 
				"+55 (0) (12) 39477891"
				, carta.lerCarta());
	}

}
