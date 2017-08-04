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
		bagtest = new MoneyBag();
		emptybag = new MoneyBag();
		unibag = new MoneyBag();
		BRL = new Currency("BRL");
		USD = new Currency("USD");
		EUR = new Currency("EUR");
		CHF = new Currency("CHF");
		maxint = 2147483647;
	}
	
	/**
	 * Esse metodo compara MoneyBag iguais
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyIguaisDevemSerIguais() {
		//Criando objetos para usar no Teste
		Money USD7 = new Money(7,USD);
		Money USD0 = new Money(0,USD);
		Money EUR0 = new Money(0,EUR);
		Money EUR7 = new Money(7,EUR);
		Money EURmax = new Money(maxint, EUR);
		Money EUR14 = new Money(14,EUR);
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
		
	}
	/**
	 * Esse metodo compara MoneyBag diferentes
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararMoneyDiferentesDevemSerDiferentes() {
		//Criando objetos para usar no Teste
		Money USD7 = new Money(7,USD);
		Money USD0 = new Money(0,USD);
		Money EUR0 = new Money(0,EUR);
		Money EUR7 = new Money(7,EUR);
		Money EURmax = new Money(maxint, EUR);
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
		
	}
	
	/**
	 * Este Metodo testa o metodo add
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDeMoneyBag_CompararMoneyBagIguaisDevemSerIguais() {
		//Criando objetos para usar no Teste
				Money USD7 = new Money(7,USD);
				Money USD0 = new Money(0,USD);
				Money EUR0 = new Money(0,EUR);
				Money EUR7 = new Money(7,EUR);
				Money EURmax = new Money(maxint, EUR);
				Money EUR14 = new Money(14,EUR);
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
	}
	/**
	 * Este Metodo testa o metodo add
	 * Passo 8
	 */
	@Test
	public void VerificarMetodoAddDeMoneyBag_CompararMoneyBagDiferentesDevemSerDiferentes() {
		//Criando objetos para usar no Teste
				Money USD7 = new Money(7,USD);
				Money USD0 = new Money(0,USD);
				Money USDmax = new Money(maxint,USD);
				Money EUR0 = new Money(0,EUR);
				Money EUR7 = new Money(7,EUR);
				Money EURmax = new Money(maxint, EUR);
				Money EUR14 = new Money(14,EUR);
				Money CHF12 = new Money(12,CHF);
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
	}
}
