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
	 * deve ser gerado uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorVazioGeraExcecao() {
		CalculadoraString.add("//[]\n");
	}
	/**
	 * Verifica se a soma esta correta quando define delimitador.
	 */
	@Test
	public void QuandoPassaNumerosComDelimitadorDefinidoRetornaSomaDosNumeros() {
		assertEquals(10, CalculadoraString.add("//[%]\n1%2%3%4"));
		assertFalse(1 == CalculadoraString.add("//[%]\n1%2%3%4"));
		assertEquals(10, CalculadoraString.add("//[;]\n1;2;3;4;"));
		assertEquals(10, CalculadoraString.add("//[@]\n@1@2@3@4@"));
		assertEquals(10, CalculadoraString.add("//[;]\n10"));
		assertEquals(10, CalculadoraString.add("//[:]\n:10:"));
		assertEquals(0, CalculadoraString.add("//[;]\n0"));
		assertEquals(10, CalculadoraString.add("//[@]\n0@010@0"));
		assertEquals(10, CalculadoraString.add("//[-]\n -1,-2 -3\n -4 -,\n"));
		
	}
	/**
	 * Verifica se a soma esta correta quando usa delimitador definido com os padroes
	 */
	@Test
	public void QuandoPassaNumerosComDelimitadorDefinidoEComDelimitadorPadraoRetornaSomaDosNumeros() {
		assertEquals(10, CalculadoraString.add("//[%]\n   1%2,3\n4\n"));
		assertFalse(1 == CalculadoraString.add("//[%]\n   1%2,3\n4\n"));
		assertEquals(10, CalculadoraString.add("//[;]\n1  2;3\n4;"));
		assertEquals(10, CalculadoraString.add("//[@]\n@1 2\n 3 @ 4@\n , "));
		assertEquals(10, CalculadoraString.add("//[;]\n  \n10,,,,"));
		assertEquals(10, CalculadoraString.add("//[:]\n : ,\n10\n, : "));
		assertEquals(0, CalculadoraString.add("//[;]\n0"));
		assertEquals(10, CalculadoraString.add("//[@]\n  0 @ 010,0\n"));
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Sem uma barra
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoSemUmaBarraGeraExcecao() {
		CalculadoraString.add("/[%]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[Delimitador]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Sem o n no final
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoSemnNoFinalGeraExcecao() {
		CalculadoraString.add("//[%]\\");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Sem [
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoSemColcheteGeraExcecao() {
		CalculadoraString.add("//%]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Com ] a mais
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoComColcheteAMaisGeraExcecao() {
		CalculadoraString.add("//[]]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador por exemplo * e usar **. 
	 * 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarDelimitadorDefinidoSemEstarIntercaladoPorNumeroGeraExcecao() {
		CalculadoraString.add("//[*]\n *1**2***3****4 ");
	}
}
