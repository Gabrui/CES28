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
import static org.junit.Assert.*;
import org.junit.Test;
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
	//Definindo alguns objetos Money para usar nos testes
	public void setUp() {
		BRL7 = new Money(7,"BRL");
		USD11 = new Money(11,"USD");
		EUR19 = new Money(19,"EUR");
		GBP7 = new Money(7,"GBP");
		maxint = 2147483647;
	}
	
	@Test
	public void VerificarMetodoAddDaClasseMoney_SomaDaMesmaMoeda() {
		//Criando alguns objetos Money para usar no teste.
		Money BRL0 = new Money(0,"BRL");
		Money BRL1 = new Money(1,"BRL");
		Money BRL07 = new Money(7,"BRL");
		Money BRL00 = new Money(0, "BRL");
		Money BRLmax = new Money(maxint, "BRL");
		Money USD0 = new Money(0,"USD");
		Money USD1 = new Money(1,"USD");
		Money USDmax = new Money(maxint,"USD");
		//Fim da Criacao de objetos
		
		//Testando com BRL
		assertTrue(BRL7.add(null).equals(null));
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
	}
}
