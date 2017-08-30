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
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import db.VerificadorCPF;
import db.BDCliente;
import db.Cliente;
import notaFiscal.NotaFiscal;
import notaFiscal.Cadastro;
import notaFiscal.ItemVenda;

/**
 * 
 *
 */
public class TesteNotaFiscal {

	
	
	@Mock private VerificadorCPF fiscalizador;
	@Mock private BDCliente bdc;
	@Mock private ItemVenda produtoVendido;
	@Mock private Cadastro casd;
	@Mock private Cliente cliente;
	
	/**
	 * Declaracao de variaveis para uso nos testes
	 */
	
	private String cpf;
	private int quant;
	private String item;
	private String notebook ;
	private String livro;
	private String caneta;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
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
		Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		
		//conferindo se o fiscalizador retorna a resposta enlatada.
		assertTrue(fiscalizador.validaCPF(cpf));
		Mockito.verify(fiscalizador, Mockito.times(1)).validaCPF(cpf);
		
		//Teste se eh possivel criar nota fiscal com cpf limpo
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,cpf,item,quant);
	}
	
	/**
	 * Testa cadastro de cliente com CPF sujo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void QuandoPassaCPFSujoNotaFiscalRetornaIllegalArgumentExceptionNaInstanciacao() {
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(false);
		Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		
		//conferindo se fiscalizador retorna a resposta enlatada
		assertFalse(fiscalizador.validaCPF(cpf));
		Mockito.verify(fiscalizador, Mockito.times(1)).validaCPF(cpf);
		
		//teste se nao eh possivel criar nota fiscal com cpf sujo
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,cpf,item,quant);
	}
	
	/**
	 * Testa se a NotaFiscal pode ser criada com itens de compra e se pode 
	 * ser adicionado itens de compra
	 */
	@Test
	public void QuandoAdicionaItemNaNotaFiscalItemEhAdicionadoNaListaDaNotaFiscal() {
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd, cpf,item,quant);
		
		//adicionando itens na nota fiscal
		testeNotaFiscal.adicionaItem(livro, quant);
		
		//Teste quantidade de itens correto
		assertTrue(testeNotaFiscal.getItem(livro) == quant);
		assertTrue(testeNotaFiscal.getItem(item) == quant);
		assertTrue(testeNotaFiscal.getItem(caneta) == 0);
	}
	
	/**
	 * Testa se a NotaFiscal consegue adicionar e deletar itens.
	 * ser adicionado itens de compra
	 */
	@Test
	public void QuandoDeletaItemNaNotaFiscalItemEhDeletadoDaListaDaNotaFiscal() {
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd, cpf,item,quant);
		
		//adiciando item na nota fiscal
		testeNotaFiscal.adicionaItem(livro, quant);
		//deletando item da nota fiscal
		testeNotaFiscal.deletaItem(item);
		
		//conferindo as quantidades dos itens na nota fiscal
		assertTrue(testeNotaFiscal.getItem(livro)== quant);
		assertTrue(testeNotaFiscal.getItem(item) == 0);
		
		testeNotaFiscal.adicionaItem(notebook, 27);
		testeNotaFiscal.adicionaItem(caneta, 7);
		testeNotaFiscal.adicionaItem(item, quant);
		
		assertTrue(testeNotaFiscal.getItem(notebook) == 27);
		assertTrue(testeNotaFiscal.getItem(caneta) == 7);
		assertTrue(testeNotaFiscal.getItem(item) == quant);
		
		testeNotaFiscal.deletaItem(notebook);
		testeNotaFiscal.deletaItem(livro);
		testeNotaFiscal.deletaItem(caneta);
		testeNotaFiscal.deletaItem(item);
		
		assertTrue(testeNotaFiscal.getItem(livro)== 0);
		assertTrue(testeNotaFiscal.getItem(item) == 0);
		assertTrue(testeNotaFiscal.getItem(livro) == 0);
		assertTrue(testeNotaFiscal.getItem(caneta) == 0);
		assertTrue(testeNotaFiscal.getItem(notebook) == 0);
	}
	
	/**
	 * Testa se o valor total da NotaFiscal esta correto
	 */
	@Test
	public void QuandoPedeValorTotalParaNotaFiscalRetornaSomaDosPrecosDeCadaItemMultiplicadoPelasQuantidades() {
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd, cpf,item,quant);
		
		//adicionando itens
		testeNotaFiscal.adicionaItem(item, quant);
		testeNotaFiscal.adicionaItem(notebook, quant);
		testeNotaFiscal.adicionaItem(caneta, quant);
		
		//verificando valor total
		assertTrue(testeNotaFiscal.getValor() == 40);
		
	}
	
	/**
	 * Testa se a NotaFiscal consegue adicionar e deletar itens.
	 * ser adicionado itens de compra
	 */
	@Test(expected = RuntimeException.class)
	public void QuandoCriaNotaFiscalComApenasUmItemETrocaPorOutroNaoPodeFicarVazia() {
		Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd, cpf,item,quant);
		
		
		//deletando item da nota fiscal
		testeNotaFiscal.deletaItem(item);
		//adiciando item na nota fiscal
		testeNotaFiscal.adicionaItem(livro, quant);
		
		//conferindo as quantidades dos itens na nota fiscal
		assertTrue(testeNotaFiscal.getItem(livro)== quant);
		assertTrue(testeNotaFiscal.getItem(item) == 0);
		assertTrue(testeNotaFiscal.getValor() == 40);
		
		
	
	}
	
}
