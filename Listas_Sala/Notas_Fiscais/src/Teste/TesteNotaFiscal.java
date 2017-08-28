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
	private String item;
	private String notebook ;
	private String livro;
	private String caneta;
	
	@Before
	public void setUp() {
		 cpf = "10";
		 quant= 10;
		 item = "item";
		 notebook = "Notebook";
		 livro = "Livro";
		 caneta = "Caneta";
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
	
	/**
	 * Testa se a NotaFiscal pode ser criada com itens de compra e se pode 
	 * ser adicionado itens de compra
	 */
	@Test
	public void QuandoAdicionaItemNaNotaFiscalItemEhAdicionadoNaListaDaNotaFiscal() {
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd, cpf,item,quant);
		testeNotaFiscal.adicionaItem(livro, quant);
		assertTrue(NotaFiscal.getItem(livro) == quant);
		assertTrue(NotaFiscal.getItem(item) == quant);
		assertTrue(NotaFiscal.getItem(caneta) == 0);
	}
	
	/**
	 * Testa se a NotaFiscal pode ser criada com itens de compra e se pode 
	 * ser adicionado itens de compra
	 */
	@Test
	public void QuandoDeletaItemNaNotaFiscalItemEhDeletadoDaListaDaNotaFiscal() {
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd, cpf,item,quant);
		testeNotaFiscal.adicionaItem(livro, quant);
		testeNotaFiscal.deletaItem(item);
		
		assertTrue(NotaFiscal.getItem(livro)== quant);
		asserTrue(NotaFiscal.getItem(item) == 0);
		
		testeNotaFiscal.adicionaItem(notebook, 27);
		testeNotaFiscal.adicionaItem(caneta, 7);
		testeNotaFiscal.adicionaItem(item, quant);
		
		assertTrue(NotaFiscal.getItem(notebook) == 27);
		assertTrue(NotaFiscal.getItem(caneta) == 7);
		asserTrue(NotaFiscal.getItem(item) == quant);
		
		testeNotaFiscal.deletaItem(notebook);
		testeNotaFiscal.deletaItem(livro);
		testeNotaFiscal.deletaItem(caneta);
		testeNotaFiscal.deletaItem(item);
		
		assertTrue(NotaFiscal.getItem(livro)== 0);
		asserTrue(NotaFiscal.getItem(item) == 0);
		assertTrue(NotaFiscal.getItem(livro) == 0);
		assertTrue(NotaFiscal.getItem(caneta) == 0);
		asserTrue(NotaFiscal.getItem(notebook) == 0);
	}
}
