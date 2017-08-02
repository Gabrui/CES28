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
		
		bagtest.add(USD7);
		bagtest.add(USD0);
		bagtest.add(EUR0);
		bagtest.add(EUR7);
		bagtest.add(EUR7);
		unibag.add(EURmax);
		
		ebagtest.add(USD7);
		ebagtest.add(USD0);
		ebagtest.add(EUR0);
		ebagtest.add(EURmax);
		unibag2.add(EUR0);
		
		bagtest2.add(EUR7);
		bagtest2.add(USD7);
		bagtest2.add(USD7);
		
		
		for(int i=0;i<7;i++) {
			sameBag.add(USD7);
		}
		
		//Verificando se sao iguais pelo metodo Equals
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
}
