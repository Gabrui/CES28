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
import main.Money;
import main.Currency;
import main.MoneyBag;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
/**
 * Class TesteMoneyBag: Testa a classe MoneyBag.
 * Passo 8 
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
	//Fim da declaracao
	
	/**
	 * Este metodo realiza algumas preparacoes para a realizacao do teste
	 * Passo 8
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
		Money USD7 = new Money(7,USD);
		Money USD0 = new Money(0,USD);
		Money USDmax = new Money(maxint,USD);
		Money EUR0 = new Money(0,EUR);
		Money EUR7 = new Money(7,EUR);
		Money EURmax = new Money(maxint, EUR);
		Money EUR14 = new Money(14,EUR);
		Money CHF12 = new Money(12,CHF);
	//Fim do setUp
	}
	
	/**
	 * Esse metodo compara MoneyBag iguais
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyIguaisDevemSerIguais() {
		//Criando objetos para usar no Teste
		MoneyBag equalbagtest = new MoneyBag();
		MoneyBag bagtest2 = new MoneyBag();
		MoneyBag unibag2 = new MoneyBag(); 
		MoneyBag bagtest3 = new MoneyBag();
		//Fim da Criacao de Objetos
		
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
		//Criando objetos para usar no Teste
		MoneyBag ebagtest = new MoneyBag();
		MoneyBag bagtest2 = new MoneyBag();
		MoneyBag unibag2 = new MoneyBag();
		MoneyBag sameBag = new MoneyBag();
		//Fim da Criacao de Objetos
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
		//Criando objetos para usar no Teste
				Money BRL0 = new Money(0,BRL);
				MoneyBag equalbagtest = new MoneyBag();
				MoneyBag unibag2 = new MoneyBag(); 
				MoneyBag bagtest3 = new MoneyBag();
				MoneyBag bagtest4 = new MoneyBag();
				MoneyBag bagtest5 = new MoneyBag();
				MoneyBag bagtest6 = new MoneyBag();
				MoneyBag bagtest7 = new MoneyBag();
				MoneyBag bagtest8 = new MoneyBag();
				MoneyBag bagtest9 = new MoneyBag();
				//Fim da Criacao de Objetos
				
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
				assertEquals(bagtest,bagtest9);
	//Fim do teste
	}
	/**
	 * Este Metodo testa o metodo add
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDeMoneyBag_CompararMoneyBagDiferentesDevemSerDiferentes() {
		//Criando objetos para usar no Teste
				MoneyBag equalbagtest = new MoneyBag();
				MoneyBag unibag2 = new MoneyBag(); 
				MoneyBag bagtest3 = new MoneyBag();
				MoneyBag bagtest4 = new MoneyBag();
				MoneyBag bagtest5 = new MoneyBag();
				MoneyBag bagtest6 = new MoneyBag();
				MoneyBag bagtest7 = new MoneyBag();
				MoneyBag bagtest8 = new MoneyBag();
				
				//Fim da Criacao de Objetos
				
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
		//Declarando variaveis para usar no teste
		MoneyBag equalbagtest = new MoneyBag();
		MoneyBag unibag2 = new MoneyBag(); 
		MoneyBag unibag3 = new MoneyBag();
		MoneyBag bagtest3 = new MoneyBag();
		MoneyBag bagtest4 = new MoneyBag();
		MoneyBag bagtest5 = new MoneyBag();
		//Fim da Declaracao
		
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
		assertTrue(bagtest.getSize(),3);
		assertTrue(equalbagtest.getSize(),3);
		assertTrue(unibag.getSize(),1);
		assertTrue(unibag2.getSize(),1);
		assertTrue(unibag3.getSize(),1);
		assertTrue(bagtest4.getSize(),2);
		assertTrue(bagtest5.getSize(),1);
		assertTrue(emptybag.getSize(),0);
		//Fim do teste
	}
	/**
	 * Metodo verifica o metodo add olhando os elementos da lista
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDaClasseMoneyBag_SeAdicionaElementoDeveTerElemento() {
		//Declarando Variaveis para usar neste teste
		MoneyBag unibag2 = new MoneyBag();
		MoneyBag unibag3 = new MoneyBag();
		MoneyBag bagtest2 = new MoneyBag();
		//Fim da Declaracao
		
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
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoGetAmountDaClasseMoneyBag_QuandoSolicitadoDeveRetornarSomaDeTudoDaMoneyBagEmBRL() {
		//Declarando variaveis para serem usadas neste teste
		Money BRL10 = new Money(10,BRL);
		MoneyBag unibag2 = new MoneyBag();
		MoneyBag unibag3 = new MoneyBag();
		MoneyBag unibag4 = new MoneyBag();
		MoneyBag unibag5 = new MoneyBag();
		MoneyBag bagtest2 = new MoneyBag();
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
		assertEquals(bagtest.getAmount(),71);
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
		
		
		//Fim do Teste
	}
}
