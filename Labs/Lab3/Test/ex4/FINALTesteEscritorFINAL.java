package ex4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Teste de Integração Final do Escritor.
 * 
 * O escritor encapsula o Idioma, ele é opcional na solução do Ex4 e Ex5, 
 * pois a Factory já realiza as especificações do Ex5.
 * 
 * O Escritor foi desenvolvimento pensando em facilitar a configuração do
 * idioma, deixando o Idioma invisível ao usuário.
 *
 */
public class FINALTesteEscritorFINAL {

	
	private Escritor escritor;
	private Pessoa remetente;
	private Pessoa destinatario;
	private Data data;
	private Endereco enderecoRemetente;
	private Endereco enderecoDestinatario;
	private Telefone fone;
	
	@Before
	public void setUp() {
		
		data = new Data(13,"Outubro",2017);
		
		enderecoRemetente = new Endereco("FazendaDourada","LugarNenhum","Livre","SemFronteiras");
		fone = new Telefone(99,00,109, 800);
		remetente = new Pessoa.PessoaBuilder("Leitor",enderecoRemetente)
				.departamento("RecursosHumanos").email("Leitor@FazendaMimosa.RecursosHumanos.com")
				.emprego("comunicacaoSocial").fone(fone).idade(22).nomeEmpresa("FazendMimosa")
				.build();
		
		enderecoDestinatario = new Endereco("CentralVeja","CidadeCentralVeja","VejaStateLiberty","Observadores");
		destinatario = new Pessoa.PessoaBuilder("Redator",enderecoDestinatario)
				.departamento("Jornalistas").email("Redator@jonarlista.veja.com")
				.emprego("jornalista").idade(40).nomeEmpresa("Veja")
				.build();
		
		escritor = new Escritor(remetente,destinatario,data);
	
	}
	
	/**
	 * Verificar se é possível instanciar um objeto Escritor.  
	 */
	@Test
	public void EhPossivelInstanciarEscritor() {
		assertNotNull(escritor);
	}
	
	@Test
	public void PedidoDeCartaComercialUSAPortugues() {
		// Cria o Escritor
		escritor = new Escritor(remetente, destinatario, data);
		
		escritor.Portugues();
		
		System.out.println(escritor.writeCartaComercialUSA().lerCarta());
		
	}

}
