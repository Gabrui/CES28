package lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteCalculadoraSimples {
	
	@Before
	public void setUp() {
	}

	@Test
	public void QuandoStringVaziaRetornaZero() {
		assertEquals(0, CalculadoraString.add(""));
	}
	
	@Test
	public void QuandoTemUmNumeroRetornaEsseNumero() {
		assertEquals(4, CalculadoraString.add("4"));
		assertEquals(442, CalculadoraString.add("442"));
	}
	
	@Test
	public void SomaNumerosSeparadosPorVirgula() {
		assertEquals(3, CalculadoraString.add("1,2"));
		assertEquals(10, CalculadoraString.add("1,2,3,4"));
	}
	
	@Test
	public void SomaNumerosSeparadosPorMarcadoresPadroes() {
		assertEquals(3, CalculadoraString.add("    1    \n, 2  "));
		assertEquals(10, CalculadoraString.add("1   ,  2\n3 4   "));
	}

}
