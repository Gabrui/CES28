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

import bd.BD;
import bd.Cliente;
import bd.VerificadorCPF;
import bd.Produto;
import org.mockito.Mock;

import notaFiscal.NotaFiscal;
import notaFiscal.ItemVenda;

/**
 * 
 *
 */
public class TesteNotaFiscal {

	
	
	@Mock private VerificadorCPF fiscalizador;
	@Mock private ItemVenda produtoVendido;
	@Mock private BD casd;
	@Mock private Cliente cliente;
	@Mock private Cliente cliente2;
	@Mock private Produto produtoItem;
	@Mock private Produto produtoNotebook;
	@Mock private Produto produtoLivro;
	@Mock private Produto produtoCaneta;
	@Mock private Produto produtoBanana;
	/**
	 * Declaracao de variaveis para uso nos testes
	 */
	
	private String cpf;
	private String cpf2;
	private int quant;
	private String item;
	private String notebook ;
	private String livro;
	private String caneta;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		 cpf = "10";
		 cpf2 = "100";
		 quant= 10;
		 item = "item";
		 notebook = "Notebook";
		 livro = "Livro";
		 caneta = "Caneta";
		 Mockito.when(fiscalizador.validaCPF(cpf)).thenReturn(true);
		 Mockito.when(casd.getCliente(cpf)).thenReturn(cliente);
		 Mockito.when(cliente.getCPF()).thenReturn(cpf);
		 Mockito.when(casd.getProdutoServico(item)).thenReturn(produtoItem);
		 Mockito.when(casd.getProdutoServico(notebook)).thenReturn(produtoNotebook);
		 Mockito.when(casd.getProdutoServico(livro)).thenReturn(produtoLivro);
		 Mockito.when(casd.getProdutoServico(caneta)).thenReturn(produtoCaneta);
		 Mockito.when(casd.getProdutoServico("banana")).thenReturn(produtoBanana);
		 Mockito.when(produtoItem.getPreco()).thenReturn(10);
		 Mockito.when(produtoNotebook.getPreco()).thenReturn(100);
		 Mockito.when(produtoLivro.getPreco()).thenReturn(1000);
		 Mockito.when(produtoCaneta.getPreco()).thenReturn(10000);
		 Mockito.when(produtoBanana.getPreco()).thenReturn(100000);

	}
	
	/**
	 * Testa cadastro de cliente com CPF limpo
	 */
	@Test
	public void QuandoPassaCPFLimpoNotaFiscalPodeSerInstaciada() {
		
		//conferindo se o fiscalizador retorna a resposta enlatada.
		assertTrue(fiscalizador.validaCPF(cpf));
		Mockito.verify(fiscalizador, Mockito.times(1)).validaCPF(cpf);
		
		//Teste se eh possivel criar nota fiscal com cpf limpo
		new NotaFiscal(casd,fiscalizador,cpf,item,quant);
	}
	
	/**
	 * Testa cadastro de cliente com CPF sujo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void QuandoPassaCPFSujoNotaFiscalRetornaIllegalArgumentExceptionNaInstanciacao() {
		Mockito.when(fiscalizador.validaCPF(cpf2)).thenReturn(false);
		Mockito.when(casd.getCliente(cpf2)).thenReturn(cliente2);
		Mockito.when(cliente.getCPF()).thenReturn(cpf2);
		
		//conferindo se fiscalizador retorna a resposta enlatada
		assertFalse(fiscalizador.validaCPF(cpf2));
		Mockito.verify(fiscalizador, Mockito.times(1)).validaCPF(cpf2);
		
		//teste se nao eh possivel criar nota fiscal com cpf sujo
		new NotaFiscal(casd,fiscalizador,cpf2,item,quant);
	}
	
	/**
	 * Testa se a NotaFiscal pode ser criada com itens de compra e se pode 
	 * ser adicionado itens de compra
	 * item d
	 */
	@Test
	public void QuandoAdicionaItemNaNotaFiscalItemEhAdicionadoNaListaDaNotaFiscal() {
		
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,fiscalizador, cpf,item,quant);
		
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
	 * item d
	 * item g
	 */
	@Test
	public void QuandoDeletaItemNaNotaFiscalItemEhDeletadoDaListaDaNotaFiscal() {

		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,fiscalizador, cpf,item,quant);
		
		//adiciando item na nota fiscal
		testeNotaFiscal.adicionaItem(livro, quant);
		//deletando item da nota fiscal
		testeNotaFiscal.deletaItem(item);
		
		//conferindo as quantidades dos itens na nota fiscal
		assertTrue(testeNotaFiscal.getItem(livro)== quant);
		assertTrue(testeNotaFiscal.getItem(item) == 0);
		
		testeNotaFiscal.adicionaItem(notebook, quant);
		testeNotaFiscal.adicionaItem(caneta,quant);
		testeNotaFiscal.adicionaItem(item, quant);
		
		assertTrue(testeNotaFiscal.getItem(notebook) == quant);
		assertTrue(testeNotaFiscal.getItem(caneta) == quant);
		assertTrue(testeNotaFiscal.getItem(item) == quant);
		
		testeNotaFiscal.deletaItem(notebook);
		testeNotaFiscal.deletaItem(livro);
		testeNotaFiscal.deletaItem(caneta);
		//testeNotaFiscal.deletaItem(item);
		
		assertTrue(testeNotaFiscal.getItem(livro)== 0);
		//assertTrue(testeNotaFiscal.getItem(item) == 0);
		assertTrue(testeNotaFiscal.getItem(livro) == 0);
		assertTrue(testeNotaFiscal.getItem(caneta) == 0);
		assertTrue(testeNotaFiscal.getItem(notebook) == 0);
	}
	
	/**
	 * Testa se o valor total da NotaFiscal esta correto
	 * item d ultima parte
	 * item e parte 1
	 */
	@Test
	public void QuandoPedeValorTotalParaNotaFiscalRetornaSomaDosPrecosDeCadaItemMultiplicadoPelasQuantidades() {
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,fiscalizador, cpf,item,quant);
		
		//adiciando item na nota fiscal
		testeNotaFiscal.adicionaItem(livro, quant);
		//deletando item da nota fiscal
		testeNotaFiscal.deletaItem(item);
		//verificando valor total
		assertTrue(testeNotaFiscal.getValor() == 10000);
		
		//adicionando itens
		testeNotaFiscal.adicionaItem(item, quant);
		testeNotaFiscal.adicionaItem(notebook, quant);
		testeNotaFiscal.adicionaItem(caneta, quant);
		
		//verificando valor total
		assertTrue(testeNotaFiscal.getValor() == 10*100+10*10+10*1000+10*10000);
		
	}
	
	/**
	 * Testa se a NotaFiscal nao pode ficar sem itens
	 * item e ultima parte
	 * item g
	 */
	@Test(expected = RuntimeException.class)
	public void QuandoCriaNotaFiscalComApenasUmItemETrocaPorOutroNaoPodeFicarVazia() {
		
		//criando nota fiscal
		NotaFiscal testeNotaFiscal = new NotaFiscal(casd,fiscalizador, cpf,item,quant);
		
		
		//deletando item da nota fiscal
		testeNotaFiscal.deletaItem(item);
		//adiciando item na nota fiscal
		testeNotaFiscal.adicionaItem(livro, quant);
		
	}
	
	/**
	 * Testa se eh possivel criar nota fiscal com quantidade nula de itens
	 * item f
	 */
	@Test(expected = RuntimeException.class)
	public void QuandoCriaNotaFiscalVaziaGeraExececao() {
		//criando nota fiscal
		new NotaFiscal(casd,fiscalizador, cpf,"banana",0);
	}
	
	/**
	 * Testa se eh possivel criar nota fiscal sem item
	 * item f
	 */
	@Test(expected = RuntimeException.class)
	public void QuandoCriaNotaFiscalStringVaziaGeraExececao() {
		//criando nota fiscal
		new NotaFiscal(casd,fiscalizador, cpf,"",10);
	}
	
	/**
	 * Testa se eh possivel criar nota fiscal sem item
	 * item f
	 */
	@Test(expected = RuntimeException.class)
	public void QuandoCriaNotaFiscalStringNaoCadastradaGeraExececao() {
		//criando nota fiscal
		new NotaFiscal(casd,fiscalizador, cpf,"bacalhau",10);
	}
}
