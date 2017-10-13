package ex4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
<<<<<<< HEAD
import org.mockito.Mockito;

import static ex4.*;
=======
>>>>>>> origin/master

public class FINALTesteEscritorFINAL {

	
	private Escritor _veja;
	private Pessoa _send;
	private Pessoa _leitor;
	private Data _hoje;
	private Endereco _end;
	private Telefone _fone;
	@Before
	public void setUp() throws Exception {
		_hoje = new Data(13,"Outubro",2017);
		_end = new Endereco("FazendaDourada","LugarNenhum","Livre","SemFronteiras");
		_fone = new Telefone(99,00,109, 800);
		_send = new Pessoa.PessoaBuilder("Leitor",_end)
				.departamento("RecursosHumanos").email("Leitor@FazendaMimosa.RecursosHumanos.com")
				.emprego("comunicacaoSocial").fone(_fone).idade(40).nomeEmpresa("FazendMimosa")
				.build();
		_end = new Endereco("CentralVeja","CidadeCentralVeja","VejaStateLiberty","Observadores");
		_fone = new Telefone(1,77,89,4000);
		_leitor = new Pessoa.PessoaBuilder("Redator",_end)
				.departamento("Jornalistas").email("Redator@jonarlista.veja.com")
				.emprego("jornalista").fone(_fone).idade(40).nomeEmpresa("Veja")
				.build();
		_veja = new Escritor(_send,_leitor,_hoje);
	
	}
	
	/**
	 * Verificar se é possível instanciar um objeto Escritor.  
	 */
	@Test
	public void EhPossivelInstanciarEscritor() {
		assertNotNull(_veja);
	}
	
	@Test
	public void PedidoDeCartaComercialUSARecebeCartaComercialUSA() {
		
		Escritor teste = Mockito.spy(_veja); 
		Carta cartaTst = teste.writeCartaComercialUSA();
		Ingles idiomaTst = Ingles.INSTANCE;
		String resposta = _hoje.toString() + "\n\n" + _send.getNome() + "\n" +
				_send.getEndereco(idiomaTst) + "\n" + _leitor.getNome() + "\n" +
				_leitor.getEndereco(idiomaTst) + "\n\n\n"
				+
				idiomaTst.vocativo() + " " + _leitor.getNome()+": " +"\n\n"
				   +"\n\n"
				+
				idiomaTst.despedida() +",\n"
				+
				"\n\n            __________________\n            "
				+ _send.getNome() + "\n            " + _send.getFone(idiomaTst)
				+ "\n            email:" + _send.getEmail();
		assertTrue(  cartaTst instanceof Carta);
		Mockito.verify(teste, Mockito.times(1)).writeCartaComercial();
		Mockito.verify(teste, Mockito.times(1)).Ingles();
		Mockito.verify(teste, Mockito.times(1)).writeCartaComercial();
		
		assertTrue(resposta == cartaTst.lerCarta());
		
	}

}
