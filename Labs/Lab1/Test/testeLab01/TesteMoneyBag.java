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
import lab01.Money;
import lab01.MoneyBag;

import org.junit.Before;
/**
 * Class TesteMoneyBag: Testa a classe MoneyBag.
 * Teste dos Passos 7,8,9 e 11 
 */
public class TesteMoneyBag {
	
	//Declarando atributos privados
	private Money USD7;
	private Money USD0 ;
	private Money USDmax;
	private Money EUR0;
	private Money EUR7;
	private Money EURmax;
	private Money EUR14;
	private Money CHF12;
	private MoneyBag bagtest;
	private MoneyBag emptybag;
	private MoneyBag unibag;
	private int maxint;
	private Currency BRL;
	private Currency USD;
	private Currency EUR;
	private Currency CHF;
	private MoneyBag equalbagtest;
	private MoneyBag bagtest2;
	private MoneyBag unibag2;
	private MoneyBag bagtest3;
	private MoneyBag ebagtest;
	private MoneyBag sameBag;
	private MoneyBag unibag3;
	private Money BRL0;
	private MoneyBag bagtest4;
	private MoneyBag bagtest5;
	private MoneyBag bagtest6;
	private MoneyBag bagtest7;
	private MoneyBag bagtest8;
	private MoneyBag bagtest9;
	//Fim da declaracao
	
	/**
	 * Este metodo realiza algumas preparacoes para a realizacao do teste
	 * Passo 4
	 */
	@Before
	public void setUp() {
		//Declarando variaveis para poder usar em todos os testes
		bagtest = new MoneyBag();
		emptybag = new MoneyBag();
		unibag = new MoneyBag();
		BRL = new Currency("BRL");
		USD = new Currency("USD");
		EUR = new Currency("EUR");
		CHF = new Currency("CHF");
		maxint = 2147483647;
		USD7 = new Money(7,USD);
		USD0 = new Money(0,USD);
		USDmax = new Money(maxint,USD);
		EUR0 = new Money(0,EUR);
		EUR7 = new Money(7,EUR);
		EURmax = new Money(maxint, EUR);
		EUR14 = new Money(14,EUR);
		CHF12 = new Money(12,CHF);
		BRL0 = new Money(0,BRL);
		equalbagtest = new MoneyBag();
		bagtest2 = new MoneyBag();
		unibag2 = new MoneyBag(); 
		bagtest3 = new MoneyBag();
		ebagtest = new MoneyBag();
		sameBag = new MoneyBag();
		unibag3 = new MoneyBag();
		bagtest4 = new MoneyBag();
		bagtest5 = new MoneyBag();
		bagtest6 = new MoneyBag();
		bagtest7 = new MoneyBag();
		bagtest8 = new MoneyBag();
		bagtest9 = new MoneyBag();
	//Fim do setUp
	}
	
	/**
	 * Esse metodo compara MoneyBag iguais
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyIguaisDevemSerIguais() {
		bagtest.add(USD7);
		bagtest.add(USD0);
		bagtest.add(EUR0);
		bagtest.add(EUR7);
		bagtest.add(EUR7);
		unibag.add(EURmax);
		
		equalbagtest.add(USD7);
		equalbagtest.add(USD0);
		equalbagtest.add(EUR0);
		equalbagtest.add(EUR7);
		equalbagtest.add(EUR7);
		unibag2.add(EURmax);
		bagtest2 = bagtest;
		bagtest3.add(USD7);
		bagtest3.add(EUR14);
		
		//Verificando se sao iguais pelo metodo Equals
		assertEquals(equalbagtest,bagtest);
		assertEquals(bagtest,equalbagtest);
		assertEquals(bagtest,bagtest);
		assertEquals(bagtest2,bagtest);
		assertEquals(bagtest,bagtest2);
		assertEquals(unibag,unibag);
		assertEquals(emptybag,emptybag);
		assertEquals(unibag2,unibag);
		assertEquals(unibag,unibag2);
		assertEquals(bagtest3,bagtest);
		assertEquals(bagtest,bagtest3);
		//Fim do teste
	}
	/**
	 * Esse metodo compara MoneyBag diferentes
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyDiferentesDevemSerDiferentes() {
		//bagtest: 7USD + 14EUR
		bagtest.add(USD7);
		bagtest.add(USD0);
		bagtest.add(EUR0);
		bagtest.add(EUR7);
		bagtest.add(EUR7);
		//unibag: maxintEUR
		unibag.add(EURmax);
		//ebagtest: 7USD+maxintEUR
		ebagtest.add(USD7);
		ebagtest.add(USD0);
		ebagtest.add(EUR0);
		ebagtest.add(EURmax);
		//unibag2: 0EUR
		unibag2.add(EUR0);
		//bagtest2: 14USD + 7EUR
		bagtest2.add(EUR7);
		bagtest2.add(USD7);
		bagtest2.add(USD7);
		
		//sameBag: 42USD
		for(int i=0;i<7;i++) {
			sameBag.add(USD7);
		}
		
		//Verificando se sao diferentes pelo metodo False
		assertFalse(ebagtest.equals(bagtest));
		assertFalse(bagtest.equals(ebagtest));
		assertFalse(unibag2.equals(unibag));
		assertFalse(unibag.equals(unibag2));
		assertFalse(unibag.equals(emptybag));
		assertFalse(emptybag.equals(unibag));
		assertFalse(bagtest.equals(emptybag));
		assertFalse(emptybag.equals(bagtest));
		assertFalse(bagtest.equals(unibag));
		assertFalse(unibag.equals(bagtest));
		assertFalse(sameBag.equals(bagtest));
		assertFalse(bagtest.equals(sameBag));
		assertFalse(bagtest.equals(bagtest2));
		assertFalse(bagtest2.equals(bagtest));
		//Fim do teste
	}
	
	/**
	 * Este Metodo testa o metodo add
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDeMoneyBag_CompararMoneyBagIguaisDevemSerIguais() {
			bagtest.add(USD7);
			bagtest.add(USD0);
			bagtest.add(EUR0);
			bagtest.add(EUR7);
			bagtest.add(EUR7);
			
			unibag.add(EURmax);
			
			equalbagtest.add(EUR0);
			equalbagtest.add(EUR7);
			equalbagtest.add(EUR7);
			equalbagtest.add(USD7);
			equalbagtest.add(USD0);
			
			unibag2.add(EURmax);
			bagtest3.add(USD7);
			bagtest3.add(EUR14);
			
			bagtest4.add(EURmax);
			bagtest4.add(USD7);
			bagtest5.add(USD7);
			bagtest5.add(EURmax);
			
            bagtest6.add(EURmax);
            bagtest6.add(USD7);
            bagtest6.add(EUR0);
			
            for(int i =0;i<6;i++) {
            	bagtest7.add(USD7);
            }
            for(int i=0;i<6;i++) {
            	bagtest7.add(EUR7);
            }
            //adicionando em uma ordem diferentes do bagtest7
            for(int i=0;i<6;i++) {
            	bagtest8.add(EUR7);
            	bagtest8.add(USD7);
            }
            //colocando BRL0 a mais do que o bagtest
            bagtest9.add(USD7);
			bagtest9.add(USD0);
			bagtest9.add(EUR0);
			bagtest9.add(EUR7);
			bagtest9.add(EUR7);
            bagtest9.add(BRL0);
			//Verificando se sao iguais pelo metodo Equals
			assertEquals(equalbagtest,bagtest);
			assertEquals(unibag2,unibag);
			assertEquals(bagtest3,bagtest);
			assertEquals(bagtest4,bagtest5);
			assertEquals(bagtest5,bagtest6);
			assertEquals(bagtest4,bagtest6);
			assertEquals(bagtest7,bagtest8);
			assertNotEquals(bagtest,bagtest9);
	//Fim do teste
	}
	/**
	 * Este Metodo testa o metodo add
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDeMoneyBag_CompararMoneyBagDiferentesDevemSerDiferentes() {
			bagtest.add(USD7);
			bagtest.add(USD0);
			bagtest.add(EUR0);
			bagtest.add(EUR7);
			bagtest.add(EUR7);
			unibag.add(EURmax);
			
			equalbagtest.add(EUR0);
			equalbagtest.add(EUR7);
			equalbagtest.add(EUR7);
			equalbagtest.add(USD7);
			equalbagtest.add(USD0);
			equalbagtest.add(CHF12);
			
			unibag2.add(EUR0);
			bagtest3.add(USD0);
			bagtest3.add(EUR14);
			
			bagtest4.add(EURmax);
			bagtest4.add(USD7);
			bagtest5.add(USDmax);
			bagtest5.add(EUR7);
			
            bagtest6.add(EURmax);
            bagtest6.add(USDmax);
            bagtest6.add(EUR0);
            bagtest6.add(CHF12);
			
            for(int i =0;i<6;i++) {
            	bagtest7.add(USD7);
            	bagtest7.add(USD0);
            	bagtest7.add(CHF12);
            }
            for(int i=0;i<6;i++) {
            	bagtest7.add(EUR7);
            	bagtest7.add(EUR0);
            }
            //adicionando em uma ordem diferentes do bagtest7
            for(int i=0;i<7;i++) {
            	bagtest8.add(USD0);
            	bagtest8.add(EUR7);
            	bagtest8.add(USD7);
            	bagtest8.add(EUR0);
            	bagtest8.add(CHF12);
            }
			//Verificando se sao iguais pelo metodo Equals
			assertFalse(equalbagtest.equals(bagtest));
			assertFalse(unibag2.equals(unibag));
			assertFalse(bagtest3.equals(bagtest));
			assertFalse(bagtest4.equals(bagtest5));
			assertFalse(bagtest5.equals(bagtest6));
			assertFalse(bagtest4.equals(bagtest6));
			assertFalse(bagtest7.equals(bagtest8));
			assertFalse(bagtest.equals(emptybag));
			assertFalse(emptybag.equals(unibag));
			//Fim do teste
	}
	/**
	 * Verifica o metodo add em relacao ao tamanho da lista
	 * Passo 8
	 */
	@Test
	public void VerificaMetodoAddDaClasseMoneyBag_SeTemMesmoTamanhoSaoIguais() {
		//montando as bags
		bagtest.add(CHF12);
		bagtest.add(CHF12);
		bagtest.add(EUR0);
		equalbagtest.add(EURmax);
		equalbagtest.add(USDmax);
		equalbagtest.add(CHF12);
		unibag.add(CHF12);
		unibag2.add(EUR0);
		unibag3.add(USDmax);
		bagtest3.add(EUR0);
		bagtest3.add(USD0);
		bagtest4.add(EUR7);
		bagtest4.add(EUR7);
		bagtest5.add(EUR14);
		//Fim da Montagem
		
		//Teste
		assertEquals(bagtest.getSize(), 2);
		assertEquals(equalbagtest.getSize(),3);
		assertEquals(unibag.getSize(),1);
		assertEquals(unibag2.getSize(),1);
		assertEquals(unibag3.getSize(),1);
		assertEquals(bagtest4.getSize(),1);
		assertEquals(bagtest5.getSize(),1);
		assertEquals(emptybag.getSize(),0);
		//Fim do teste
	}
	/**
	 * Metodo verifica o metodo add olhando os elementos da lista
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDaClasseMoneyBag_SeAdicionaElementoDeveTerElemento() {
		//Montando as bags
		bagtest.add(CHF12);
		bagtest.add(EUR7);
		bagtest.add(EUR7);
		bagtest.add(USDmax);
		unibag.add(CHF12);
		unibag2.add(EUR0);
		unibag3.add(USDmax);
		bagtest2.add(EUR14);
		//Fim da Montagem
		
		//Testando
		assertTrue(bagtest.hasMoney(CHF12));
		assertTrue(bagtest.hasMoney(EUR14));
		assertTrue(bagtest.hasMoney(USDmax));
		assertFalse(bagtest.hasMoney(EUR7));
		assertFalse(bagtest.hasMoney(USD0));
		assertTrue(unibag.hasMoney(CHF12));
		assertFalse(unibag.hasMoney(EUR7));
		assertTrue(unibag2.hasMoney(EUR0));
		assertTrue(unibag3.hasMoney(USDmax));
		assertTrue(bagtest2.hasMoney(EUR14));
		assertFalse(bagtest2.hasMoney(EUR7));
		assertFalse(bagtest2.hasMoney(CHF12));
		assertFalse(emptybag.hasMoney(CHF12));
		assertFalse(emptybag.hasMoney(EUR0));
		assertFalse(emptybag.hasMoney(USDmax));
		//Fim do teste
	}
	/**
	 * Este Metodo testa o metood Add da Classe MoneyBag verificando se a soma de todos os elementos da lista esta correto
	 * Passo 8, Teste da implementacao do Passo 11
	 */
	@Test
	public void VerificarMetodoGetAmountDaClasseMoneyBag_QuandoSolicitadoDeveRetornarSomaDeTudoDaMoneyBagEmBRL() {
		//Declarando variaveis para serem usadas neste teste
		Money BRL10 = new Money(10,BRL);
		MoneyBag unibag4 = new MoneyBag();
		MoneyBag unibag5 = new MoneyBag();
		//Fim da declaracao
		
		//Montando MoneyBags
		bagtest.add(EUR7);
		bagtest.add(EUR0);
		bagtest.add(USD7);
		bagtest.add(BRL10);
		bagtest.add(CHF12);
		
		unibag.add(EUR7);
		unibag2.add(BRL10);
		unibag3.add(USD7);
		unibag4.add(CHF12);
		unibag5.add(USD0);
		
		bagtest2.add(EUR0);
		bagtest2.add(EUR7);
		bagtest2.add(EUR14);
		//Fim da Montagem
		
		//Teste
		assertEquals(bagtest.getAmount(),83);
		assertEquals(unibag.getAmount(),28);
		assertEquals(unibag2.getAmount(),10);
		assertEquals(unibag3.getAmount(),21);
		assertEquals(unibag4.getAmount(),24);
		assertEquals(unibag5.getAmount(),0);
		assertEquals(bagtest2.getAmount(),84);
		assertFalse(bagtest.getAmount() == 0);
		assertFalse(unibag.getAmount() == 0);
		assertFalse(unibag.getAmount() == 7);
		assertFalse(bagtest2.getAmount() == 21);
		assertEquals(emptybag.getAmount(),0);
		assertFalse(emptybag.getAmount() == 1);
		assertFalse(unibag5.getAmount() == 1);
		//Fim do Teste
	}
	/**
	 * Teste do metodo hasCurrency da Classe MoneyBag
	 * Passo 8
	 */
	@Test
	public void VerificarMetodohasCurrencyDaClasseMoneyBag_QuandoColocaUmaMoedaDeveConterEssaMoeda() {
		
		//Montando Moneybags
		bagtest.add(CHF12);
		bagtest.add(EUR0);
		bagtest.add(USDmax);
		bagtest.add(CHF12);
		bagtest.add(EUR14);
		
		unibag.add(CHF12);
		unibag2.add(EUR0);
		unibag3.add(USDmax);
		//Fim da montagem
		
		//Teste
		assertTrue(bagtest.hasCurrency(CHF));
		assertTrue(bagtest.hasCurrency(USD));
		assertTrue(bagtest.hasCurrency(EUR));
		assertTrue(unibag.hasCurrency(CHF));
		assertFalse(bagtest.hasCurrency(BRL));
		assertFalse(unibag.hasCurrency(USD));
		assertFalse(emptybag.hasCurrency(BRL));
		assertFalse(emptybag.hasCurrency(USD));
		assertTrue(unibag2.hasCurrency(EUR));
		assertFalse(unibag2.hasCurrency(USD));
		assertTrue(unibag3.hasCurrency(USD));
		assertFalse(unibag3.hasCurrency(BRL));
		//Fim do Teste
	}
	/**
	 * Teste do Metodo ToString
	 * Passo 8 e 9
	 */
	@Test
	public void VerificarMetodoToStringDaClasseMoneyBag_SeTemMoneyEntaoToStringDeveRetornarStringDaListaDeMoneys() {
		//Montando MoneyBags
		bagtest.add(CHF12);
		bagtest.add(EUR0);
		bagtest.add(USDmax);
		bagtest.add(EUR7);
		
		unibag.add(CHF12);
		unibag2.add(EUR0);
		unibag3.add(USDmax);
		bagtest2.add(USD0);
		bagtest2.add(EUR7);
		//Fim da Montagem
		
		//Teste
		assertTrue(emptybag.toString().equals(""));
		assertTrue(bagtest.toString().equals("12 CHF, 7 EUR, 2147483647 USD"));
		assertFalse(bagtest.toString().equals(""));
		assertFalse(bagtest.toString().equals("12 CHF, 0 EUR, 7 EUR, 2147483647 USD"));
		assertFalse(bagtest.toString().equals("CHF 12, EUR 7, USD 2147483647"));
		assertFalse(bagtest.toString().equals("CHF 12, EUR 7, USD 2147483647, "));
		assertTrue(unibag.toString().equals("12 CHF"));
		assertFalse(unibag.toString().equals("12 CHF, "));
		assertTrue(unibag2.toString().equals("0 EUR"));
		assertFalse(unibag2.toString().equals("0 EUR, "));
		assertFalse(unibag2.toString().equals(" EUR"));
		assertFalse(unibag2.toString().equals(" EUR, "));
		assertFalse(unibag2.toString().equals("  EUR"));
		assertFalse(unibag2.toString().equals("  EUR, "));
		assertFalse(unibag2.toString().equals(""));
		assertTrue(unibag3.toString().equals("2147483647 USD"));
		assertFalse(unibag3.toString().equals("2147483647 USD, "));
		assertTrue(bagtest2.toString().equals("0 USD, 7 EUR"));
		assertFalse(bagtest2.toString().equals("7 EUR, 0 USD"));
		assertFalse(bagtest2.toString().equals("7 EUR, 0 USD, "));
		assertFalse(bagtest2.toString().equals("0 USD, 7 EUR, "));
		assertFalse(bagtest2.toString().equals("7 EUR"));
		assertFalse(bagtest2.toString().equals("7 EUR, "));
		assertFalse(bagtest2.toString().equals(" USD, 7 EUR"));
		assertFalse(bagtest2.toString().equals(" USD, 7 EUR, "));
		//Fim do Teste
	}
}
