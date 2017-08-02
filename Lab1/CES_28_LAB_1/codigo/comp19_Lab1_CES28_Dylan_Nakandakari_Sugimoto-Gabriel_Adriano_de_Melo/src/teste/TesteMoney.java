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
	
	@Before
	//Definindo alguns objetos Money para usar nos testes
	public void setUp() {
		BRL7 = new Money(7,"BRL");
		USD11 = new Money(11,"USD");
		EUR19 = new Money(19,"EUR");
		GBP7 = new Money(7,"GBP");
		maxint = 2147483647;
	}
	
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoCompararIguaisDevemSerIguais() {
		//Criando objetos para usar no Teste
		Money GBP07 = new Money(7,"GBP");
		Money GBP0 = new Money(0,"GBP");
		Money GBPmax = new Money(maxint,"GBP");
		Money EUR019 = new Money(19,"EUR");
		Money EUR7 = new Money(7,"EUR");
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
	
	@Test
	public void VerificarMetodoEqualDaClasseMoney_QuandoComparaDiferenteDevemSerDiferentes() {
		//Criando objetos para usar no Teste
				Money GBP07 = new Money(7,"GBP");
				Money GBP0 = new Money(0,"GBP");
				Money GBPmax = new Money(maxint,"GBP");
				Money EUR019 = new Money(19,"EUR");
				Money EUR7 = new Money(7,"EUR");
				//Fim da Criacao de Objetos
				
		//conferindo quando sao diferentes
				assertTrue(!(GBP7.equals(GBP0)));
				assertTrue(!(GBP7.equals(EUR7)));
				assertTrue(!(EUR019.equals(GBP7)));
				assertTrue(!(GBP7.equals(GBPmax)));
				assertTrue(!(GBPmax.equals(EUR19)));
		
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
	
	
}
