package ex4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static ex4.*;

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
<<<<<<< HEAD
	public void EhPossivelInstanciarEscritor() {
		assertNotNull(_veja);
=======
	public void test() {
		//fail("Not yet implemented");
>>>>>>> Teste Pessoa Ex4
	}

}
