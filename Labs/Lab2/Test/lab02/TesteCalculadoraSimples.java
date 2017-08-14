/**
 * Disciplina CES-28
 * Data: 14/08/2017
 * @author: Dylan N. Sugimoto, Gabriel Adriano de Melo.
 * 
 */

package lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo
 * Esta Classe testa a classe CalculadoraString.
 * 
 */
public class TesteCalculadoraSimples {
	
	@Before
	public void setUp() {
		
	}

	/**
	 * Quando é passado uma string vazia para o metodo add da classe CalculadoraString
	 * ela retorna zero.
	 * 
	 */
	@Test
	public void QuandoStringVaziaRetornaZero() {
		assertEquals(0, CalculadoraString.add(""));
	}
	
	/**
	 * Testa se o numero passado como string é retornado como int. 
	 * 
	 */
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
	/**
	 * Marcadores Padroes: " " ou "\n" ou ",".
	 * 
	 */
	@Test
	public void SomaNumerosSeparadosPorMarcadoresPadroes() {
		assertEquals(3, CalculadoraString.add("    1    \n, 2  "));
		assertEquals(10, CalculadoraString.add("1   ,  2\n3 4   "));
	}
	/**
	 * Marcadores Padroes: " " ou  "\n" ou  ",".
	 */
	@Test
	public void RetornaZeroQuandoRecebeApenasMarcadoresPadroes() {
		assertEquals(0, CalculadoraString.add("\n\n\n"));
		assertEquals(0, CalculadoraString.add(",,,"));
		assertEquals(0, CalculadoraString.add("   "));
		assertEquals(0, CalculadoraString.add(" \n , \n , , , ,,, \n\n\n  "));
		
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Testando se o metodo add permite definir delimitadores, ou seja,
	 * se quando definimos um delimitador nao eh gerado um erro e retorna zero
	 */
	@Test
	public void VerificaSeAddPermiteDefinirDelimitador() {
		assertEquals(0, CalculadoraString.add("//[%]\n"));
		assertEquals(0, CalculadoraString.add("//[;]\n"));
		assertEquals(0, CalculadoraString.add("//[ ]\n"));
	}
	/**
	 * Nao eh permitido definir delimitador vazio. Caso isso aconteca,
	 * deve ser gerado uma excecao
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorVazioGeraExcecao() {
		CalculadoraString.add("//[]\n");
	}
	/**
	 * 
	 */
	@Test
	public void QuandoDefineDelimitadorComNumerosRetornaSomaDosNumeros() {
		
	}
}
