/**
 * Aula 05 - Nota Fiscal
 * @author Dylan N. Sugimoto
 * @author Gabriel Adriano de Melo
 * Dia: 28/08/2017
 */
package Teste;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.Mock;
import db.VerificadorCPF;
import db.BDCliente;
import notaFiscal.NotaFiscal;
import notaFiscal.Cadastro;

/**
 * 
 *
 */
public class TesteNotaFiscal {

	
	
	@Mock private VerificadorCPF fiscalizador;
	@Mock private BDCliente bdc;
	
	/**
	 * Declaracao de variaveis para uso nos testes
	 */
	private Cadastro casd = new Cadastro(bdc,fiscalizador);
	private String cpf;
	private int quant;
	private String item ;
	@Before
	public void setUp() {
		 cpf = "10";
		 quant= 10;
		 item = "Notebook";
	}
	
	/**
	 * Testa cadastro de cliente com CPF limpo
	 */
	@Test
	public void QuandoPassaCPFLimpoNotaFiscalPodeSerInstaciada() {
		
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		assertTrue(fiscalizador.validaCPF(cpf));
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,cpf,item,quant);
	}
	
	/**
	 * Testa cadastro de cliente com CPF sujo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void QuandoPassaCPFSujoNotaFiscalRetornaIllegalArgumentExceptionNaInstanciacao() {
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(false);
		assertFalse(fiscalizador.validaCPF(cpf));
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,cpf,item,quant);
	}
	
}
