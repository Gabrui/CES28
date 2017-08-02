/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes de teste
 */
package teste;
import main.Currency;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Class TesteCurrency: Testa os metodos da classe Currency do pacote main.
 *Passo 6
 */
public class TesteCurrency {
	
	//Declarando atributos privados
	private int maxint;
	private Currency BRL;
	private Currency USD;

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
		
		maxint = 2147483647;
	}
	
	/**
	 * Passo 6
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
	 * Passo 6
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
	 * Passo 6
	 */
	@Test
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoDeveAtribuirUmNomeDoTipoString() {
	
		
		assertTrue(BRL.getSigla() instanceof String);
		
	}
	/**
	 * Este metodo verifica se o atributo possui tamanho 3
	 * Passo 6
	 */
	@Test
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoDeveAtribuirUmNomeDeTamanho3() {
		
		assertTrue(BRL.getSigla().length() == 3);
		
	}
	/**
	 * Este metodo verifica se o atributo recebe o parametro passado
	 * Passo 6
	 */
	@Test
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoDeveAtribuirParametroPassado() {
		//Criando Objetos
		Currency BRL2 = new Currency("BRL");

		assertEquals(BRL,BRL2);
		assertTrue(!(BRL.equals(USD)));
		assertTrue(BRL.getSigla().equals("BRL"));
		assertTrue(!(BRL.getSigla().equals("USD")));
	}
	/**
	 * Este metodo verifica se um valor de excecao eh gerado quando um nome maior que 3 eh passado
	 * Passo 6
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoComNomeMaiorQue3DeveGerarUmaExcecao() {
		//Criando Objeto Currency com nome maior que 3
		//Espera-se que uma excecao seja gerada
		Currency BRLL = new Currency("BRLL");
		
	}
	/**
	 * Este metodo verifica se um valor de excecao eh gerado quando um nome menor que 3 eh passado
	 * Passo 6 
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoComNomeMenorQue3DeveGerarUmaExcecao() {
		// Criando Objeto Currency com nome menor que 3
		//Espera-se que uma excecao seja gerada
		Currency BR = new Currency("BR");
	}
	/**
	 * Este metodo verifica se um valor de exececao eh gerado quando um nome vazio eh passado
	 * Passo 6
	 */
	@Test (expected = RuntimeException.class)
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoComNomeVazioDeveGerarUmaExcecao() {
		// Criando Objeto Currency com nome Vazio
		//Espera-se que uma excecao seja gerada
		Currency vazio = new Currency("");
	}
	/**
	 * Este metodo verifica se o metodo clonar da Classe Currency retorna um currency igual
	 * Passo 6
	 */
	public void VerificarClonarDaClasseCurrency_QuandoClonarRetornaUmCurrencyIgual() {
		//Clonando
		Currency BRL2 = BRL.clonar();
		
		//Testes
		assertNotNull(BRL2);
		assertEquals(BRL,BRL2);
		assertTrue(!(BRL2.equals(USD)));
		assertNotSame(BRL,BRL2);
		
	}
}
