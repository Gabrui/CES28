/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes de teste
 */
package teste;
import main.Money;
import main.Currency;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Class TesteMoney: Possui metodos que testam a classe Money
 * 
 *
 */
public class TesteMoney {
	private Money BRL7;
	private Money USD11;
	private Money EUR19;
	private Money GBP7;
	private int maxint;
	private java.util.Currency BRL;
	private java.util.Currency USD;
	private Currency EUR;
	private Currency GBP;
	
	@Before
	//Definindo alguns objetos Money para usar nos testes
	public void setUp() {
		BRL = new Currency("BRL");
		USD = new Currency("USD");
		EUR = new Currency("EUR");
		GBP = new Currency("GBP");
		BRL7 = new Money(7,BRL);
		USD11 = new Money(11,USD);
		EUR19 = new Money(19,EUR);
		GBP7 = new Money(7,GBP);
		maxint = 2147483647;
	}
	/**
	 * Esse metodo compara money iguais
	 * 
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyIguaisDevemSerIguais() {
		//Criando objetos para usar no Teste
		Money GBP07 = new Money(7,GBP);
		Money GBP0 = new Money(0,GBP);
		Money GBPmax = new Money(maxint,GBP);
		Money EUR019 = new Money(19,EUR);
		Money EUR7 = new Money(7,EUR);
		//Fim da Criacao de Objetos
		
		//Verificando se sao iguais pelo metodo Equals
		assertEquals(GBP7,GBP07);
		assertEquals(GBP0,GBP0);
		assertEquals(GBP7,GBP7);
		assertEquals(GBPmax,GBPmax);
		assertEquals(EUR019,EUR019);
		assertEquals(EUR19,EUR019);
		//repetindo
		assertTrue(GBP7.equals(GBP07));
		assertTrue(GBP7.equals(GBP7));
		assertTrue(GBP0.equals(GBP0));
		assertTrue(EUR019.equals(EUR019));
		assertTrue(EUR019.equals(EUR19));
		assertTrue(GBPmax.equals(GBPmax));
		
	}
	/**
	 * Esse metodo compara money diferentes
	 * 
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoComparaMoneyDiferenteDevemSerDiferentes() {
		//Criando objetos para usar no Teste
				Money GBP07 = new Money(7,GBP);
				Money GBP0 = new Money(0,GBP);
				Money GBPmax = new Money(maxint,GBP);
				Money EUR019 = new Money(19,EUR);
				Money EUR7 = new Money(7,EUR);
				//Fim da Criacao de Objetos
				
		//conferindo quando sao diferentes
				assertTrue(!(GBP7.equals(GBP0)));
				assertTrue(!(GBP7.equals(EUR7)));
				assertTrue(!(EUR019.equals(GBP7)));
				assertTrue(!(GBP7.equals(GBPmax)));
				assertTrue(!(GBPmax.equals(EUR19)));
		
	}
	/**
	 * Esse metodo realiza o teste da soma entre mesma moeda.
	 * Passo 2, 3, 4 e 6.
	 * 
	 */
	@Test
	public void VerificarMetodoAddDaClasseMoney_SomaDaMesmaMoeda() {
		//Criando alguns objetos Money para usar no teste.
		Money BRL0 = new Money(0,BRL);
		Money BRL1 = new Money(1,BRL);
		Money BRL07 = new Money(7,BRL);
		Money BRL00 = new Money(0, BRL);
		Money BRLmax = new Money(maxint, BRL);
		Money USD0 = new Money(0,USD);
		Money USD1 = new Money(1,USD);
		Money USDmax = new Money(maxint,USD);
		//Fim da Criacao de objetos
		
		//Testando com BRL
		assertTrue(BRL7.add(BRL0).getAmount() == 7);
		assertTrue(BRL0.add(BRL1).getAmount() == 1);
		assertTrue(BRL07.add(BRL7).getAmount() == 14);
		assertTrue(BRL00.add(BRL0).getAmount() == 0);
		assertTrue(BRLmax.add(BRL7).getAmount() > maxint);
		assertTrue(BRL7.add(BRLmax).getAmount() > maxint);
		assertTrue(BRLmax.add(BRL0).getAmount() == maxint);
		//Testando com USD
		assertTrue(USD11.add(USD0).getAmount() == 7);
		assertTrue(USD0.add(USD1).getAmount() == 1);
		assertTrue(USD0.add(USD0).getAmount() == 0);
		assertTrue(USDmax.add(USD11).getAmount() > maxint);
		assertTrue(USD11.add(USDmax).getAmount() > maxint);
		assertTrue(USDmax.add(USD0).getAmount() == maxint);
		
		//Usando Equals
		assertEquals(USD0.add(USD1),USD1);
		assertEquals(USD0.add(USD0),USD0);
		assertEquals(USDmax.add(USD0),USDmax);
	}
	
	/**
	 * Passo 6
	 * Esse metodo compara currency iguais
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
	 * Esse metodo compara currency diferentes
	 * 
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
	 * 
	 */
	@Test
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoDeveAtribuirUmNomeDoTipoString() {
		//Criando Objetos
		Currency BRL2 = new Currency("BRL");
		
		assertTrue(BRL.getNome() instanceof String);
		
	}
	/**
	 * Este metodo verifica se o atributo possui tamanho 3
	 * 
	 */
	@Test
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoDeveAtribuirUmNomeDeTamanho3() {
		//Criando Objetos
		Currency BRL2 = new Currency("BRL");
		
		assertTrue(BRL.getNome().length == 3);
		
	}
	/**
	 * Este metodo verifica se o atributo recebe o parametro passado
	 * 
	 */
	@Test
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoDeveAtribuirParametroPassado() {
		//Criando Objetos
		Currency BRL2 = new Currency("BRL");

		assertEqual(BRL,BRL2);
		assertTrue(!(BRL.equals(USD)));
		assertTrue(BRL.getNome().equals("BRL"));
		assertTrue(!(BRL.getNome().equals("USD")));
	}
	/**
	 * Este metodo verifica se um valor de excecao eh gerado quando um nome maior que 3 eh passado
	 * 
	 */
	@Test (Expected = RuntimeException.class)
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoComNomeMaiorQue3DeveGerarUmaExcecao() {
		//Criando Objeto Currency com nome maior que 3
		//Espera-se que uma excecao seja gerada
		Currency BRLL = new Currency("BRLL");
		
	}
	/**
	 * Este metodo verifica se um valor de excecao eh gerado quando um nome menor que 3 eh passado
	 * 
	 */
	@Test (Expected = RuntimeException.class)
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoComNomeMenorQue3DeveGerarUmaExcecao() {
		// Criando Objeto Currency com nome menor que 3
		//Espera-se que uma excecao seja gerada
		Currency BR = new Currency("BR");
	}
	/**
	 * Este metodo verifica se um valor de exececao eh gerado quando um nome vazio eh passado
	 * 
	 */
	@Test (Expected = RuntimeException.class)
	public void VerificarConstrutorDaClasseCurrency_QuandoCriadoComNomeVazioDeveGerarUmaExcecao() {
		// Criando Objeto Currency com nome Vazio
		//Espera-se que uma excecao seja gerada
		Currency vazio = new Currency("");
	}
	/**
	 * Este metodo verifica se o metodo clonar da Classe Currency retorna um currency igual
	 * 
	 */
	public void VerificarClonarDaClasseCurrency_QuandoClonarRetornaUmCurrencyIgual() {
		//Clonando
		Money BRL2 = BRL.clonar();
		
		//Testes
		assertNotNull(BRL2);
		assertEquals(BRL,BRL2);
		assertTrue(!(BRL2.equals(USD)));
		assertNotSame(BRL,BRL2);
		
	}
}
