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
	 * 
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
	
}
