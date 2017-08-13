/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes de teste
 */
package testeLab01;
import static org.junit.Assert.*;
import org.junit.Test;

import lab01.Currency;

import org.junit.Before;

/**
 * Class TesteCurrency: Testa os metodos da classe Currency do pacote main.
 *Passo 6 e teste da implementacao do Passo 5
 */
public class TesteCurrency {
	
	//Declarando atributos privados
	private Currency BRL;
	private Currency USD;
	private Currency EUR;
	private Currency CHF;

	//Fim da declaracao
	
	/**
	 * Este metodo realiza algumas preparacoes para a realizacao do teste
	 * Passo 4
	 */
	@Before
	//Definindo alguns objetos Money para usar nos testes
	public void setUp() {

		BRL = new Currency("BRL");
		USD = new Currency("USD");
		EUR = new Currency("EUR");
		CHF = new Currency("CHF");

	}
	
	/**
	 * Passo 6 e teste da implementacao do Passo 5
	 * Este metodo compara currency iguais
	 * 
	 */
	@Test
	public void VerificarMetodoEqualsDaClasseCurrency_QuandoComparaCurrencyIguaisDevemSerIguais() {
		//Criando objetos currency para serem usados no teste
		Currency BRL2 = new Currency("BRL");
		Currency USD2 = new Currency("USD");
		//Fim da Criacao
		
		//Testando
		assertEquals(BRL,BRL2);
		assertEquals(USD2,USD);
		
	}
	/**
	 * Este metodo compara currency diferentes
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificarMetodoEqualsDaClasseCurrency_QuandoComparaCurrencyDiferenteDevemSerDiferentes() {
		//Criando um objeto com nome parecido ao de BRL
		Currency BRR = new Currency("BRR");
		
		//Testando currency com nomes diferentes
		assertTrue(!BRL.equals(BRR));
		assertTrue(!BRL.equals(USD));
		assertTrue(!USD.equals(BRL));
		
	}
	/**
	 * Este metodo verifica se o atributo recebe uma string
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificarSetSiglaDaClasseCurrency_QuandoCriadoDeveAtribuirUmNomeDoTipoString() {
	
		
		assertTrue(BRL.getSigla() instanceof String);
		
	}
	/**
	 * Este metodo verifica se o atributo possui tamanho 3
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificarSetSiglaDaClasseCurrency_QuandoCriadoDeveAtribuirUmNomeDeTamanho3() {
		
		assertTrue(BRL.getSigla().length() == 3);
		
	}
	/**
	 * Este metodo verifica se o atributo recebe o parametro passado
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificarSetSiglaDaClasseCurrency_QuandoCriadoDeveAtribuirParametroPassado() {
		//Criando Objetos
		Currency BRL2 = new Currency("BRL");

		assertEquals(BRL,BRL2);
		assertTrue(!(BRL.equals(USD)));
		assertTrue(BRL.getSigla().equals("BRL"));
		assertTrue(!(BRL.getSigla().equals("USD")));
	}
	/**
	 * Este metodo verifica se um valor de excecao eh gerado quando um nome maior que 3 eh passado
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarSetSiglaDaClasseCurrency_QuandoCriadoComNomeMaiorQue3DeveGerarUmaExcecao() {
		//Criando Objeto Currency com nome maior que 3
		//Espera-se que uma excecao seja gerada
		@SuppressWarnings("unused")
		Currency BRLL = new Currency("BRLL");
		
	}
	/**
	 * Este metodo verifica se um valor de excecao eh gerado quando um nome menor que 3 eh passado
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarSetSiglaDaClasseCurrency_QuandoCriadoComNomeMenorQue3DeveGerarUmaExcecao() {
		// Criando Objeto Currency com nome menor que 3
		//Espera-se que uma excecao seja gerada
		@SuppressWarnings("unused")
		Currency BR = new Currency("BR");
	}
	/**
	 * Este metodo verifica se um valor de exececao eh gerado quando um nome vazio eh passado
	 * Passo 6 e teste da implementacao do Passo 5
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarSetSiglaDaClasseCurrency_QuandoCriadoComNomeVazioDeveGerarUmaExcecao() {
		// Criando Objeto Currency com nome Vazio
		//Espera-se que uma excecao seja gerada
		@SuppressWarnings("unused")
		Currency vazio = new Currency("");
	}
	/**
	 * Este metodo verifica se o metodo clonar da Classe Currency retorna um currency igual
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificarClonarDaClasseCurrency_QuandoClonarRetornaUmCurrencyIgual() {
		//Clonando
		Currency BRL2 = BRL.clonar();
		//Testes
		assertNotNull(BRL2);
		assertEquals(BRL,BRL2);
		assertTrue(!(BRL2.equals(USD)));
		assertNotSame(BRL,BRL2);
		
	}
	/**
	 * Este metodo verifica o metodo da taxa de cambio da classe Currency
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificargetTaxaDeCambioParaReaisDaClasseCurrency_QuandoCambiarRetornaUmInteiro() {
		
		//Teste
		assertTrue(BRL.getTaxaDeCambioParaReais() == 1);
		assertTrue(USD.getTaxaDeCambioParaReais() == 3);
		assertTrue(EUR.getTaxaDeCambioParaReais() == 4);
		assertTrue(CHF.getTaxaDeCambioParaReais() == 2);
		assertFalse(BRL.getTaxaDeCambioParaReais() == 2);
		assertFalse(USD.getTaxaDeCambioParaReais() == 0);
		assertFalse(EUR.getTaxaDeCambioParaReais() == 100);
		assertFalse(CHF.getTaxaDeCambioParaReais() == 10);
	}
	/**
	 * Este metodo verifica o metodo toString da classe Currency
	 *  Passo 6 e teste da implementacao do Passo 5
	 */
	@Test
	public void VerificartoStringDaClasseCurrency_QuandoImprimirRetornarNomeDaCurrency() {
		
		//Teste
		assertTrue(BRL.toString().equals("BRL"));
		assertFalse(BRL.toString().equals("USD"));
	}
}
