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
import org.junit.rules.ExpectedException;
import org.junit.Rule;

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
	 * Passo 1
	 */
	@Test
	public void QuandoStringVaziaRetornaZero() {
		assertEquals(0, CalculadoraString.add(""));
	}
	
	/**
	 * Testa se o numero passado como string é retornado como int. 
	 * Passo 1
	 */
	@Test
	public void QuandoTemUmNumeroRetornaEsseNumero() {
		assertEquals(4, CalculadoraString.add("4"));
		assertEquals(442, CalculadoraString.add("442"));
	}
	
	/**
	 * Passo 1 e teste do Passo 2
	 */
	@Test
	public void SomaNumerosSeparadosPorVirgula() {
		assertEquals(3, CalculadoraString.add("1,2"));
		assertEquals(10, CalculadoraString.add("1,2,3,4"));
	}
	
	/**
	 * Nao eh permitido usar letra como delimitador. 
	 * Passo 1
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarLetraComoDelimitadorNaoDefinidoGeraExcecao() {
		CalculadoraString.add("X1X2X3X4");
	}

	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido usar delimitador nao definido. 
	 * Passo 1
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarDelimitadorNaoDefinidoSemNumeroGeraExcecao() {
		CalculadoraString.add("%");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido usar delimitador nao definido. 
	 * Passo 1
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarDelimitadorNaoDefinidoComNumeroGeraExcecao() {
		CalculadoraString.add(" % 1  2 \n3,4");
	}
	
	
	
	/**
	 * Marcadores Padroes: " " ou "\n" ou ",".
	 * Passo 3
	 */
	@Test
	public void SomaNumerosSeparadosPorMarcadoresPadroes() {
		assertEquals(3, CalculadoraString.add("    1    \n, 2  "));
		assertEquals(10, CalculadoraString.add("1   ,  2\n3 4   "));
	}
	/**
	 * Marcadores Padroes: " " ou  "\n" ou  ",".
	 * Passo 3
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
	 * Passo 4
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
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorVazioGeraExcecao() {
		CalculadoraString.add("//[]\n");
	}
	/**
	 * Verifica se a soma esta correta quando define delimitador.
	 * Passo 4
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
		assertEquals(10, CalculadoraString.add("//[-]\n-1-2-3-4"));
		assertEquals(10, CalculadoraString.add("//[a]\na1a2a3a4"));
		assertEquals(10, CalculadoraString.add("//[B]\nB1B2B3B4B"));
		assertEquals(10, CalculadoraString.add("//[	]\n	1	2	3	4	"));
	}
	/**
	 * Verifica se a soma esta correta quando usa delimitador definido com os padroes
	 * Passo 4
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
		assertEquals(10, CalculadoraString.add("//[-]\n -1,-2 -3\n -4 -,\n"));
		assertEquals(10, CalculadoraString.add("//[%]\n  % %\n %,\n \n%, \n%, 1%2,3\n4\n"));
		assertEquals(10, CalculadoraString.add("//[a]\n a 1\n a 2, a ,3, ,a, \n, 4 "));
		assertEquals(10, CalculadoraString.add("//[B]\n B 1, B, ,2, ,B, ,3,\n B,\n ,4, ,B, "));//testando com tab
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Sem uma barra
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoSemUmaBarraGeraExcecao() {
		CalculadoraString.add("/[%]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[Delimitador]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Sem o n no final
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoSemnNoFinalGeraExcecao() {
		CalculadoraString.add("//[%]\\");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Sem [
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoSemColcheteGeraExcecao() {
		CalculadoraString.add("//%]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Com ] a mais
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoComColcheteAMaisGeraExcecao() {
		CalculadoraString.add("//[]]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Com [ a mais
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoComColcheteEsquerdoAMaisGeraExcecao() {
		CalculadoraString.add("//[[]\n");
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador por exemplo * e usar **. 
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarDelimitadorDefinidoSemEstarIntercaladoPorNumeroGeraExcecao() {
		CalculadoraString.add("//[*]\n *1**2***3****4 **********************************");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido usar tab como delimitador padrao. 
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarTabAoInvesDeEspacoEmBrancoGeraExcecao() {
		CalculadoraString.add("	1	2,3\n4	");
	}
	
	
	@Rule
	public final ExpectedException expectedExcecao = ExpectedException.none();
	/**
	 * Quando recebe um numero negativo deve lancar uma excecao
	 * e uma mensagem bem definido com o numero negativo passado.
	 * Passo 5
	 */
	@Test
	public void QuandoRecebeApenasUmNumeroNegativoGeraExcecao(){
		expectedExcecao.expect(IllegalArgumentException.class);
		expectedExcecao.expectMessage("negativos proibidos [-1]");
		CalculadoraString.add("-1");
	}
	
	/**
	 * Quando recebe alguns numeros negativos deve lancar uma excecao
	 * e uma mensagem bem definido com todos numeros negativos passados.
	 * Passo 5
	 */
	@Test
	public void QuandoRecebeNumerosNegativosGeraExcecaoComMessagemComTodosOsNumerosNegativos(){
		expectedExcecao.expect(IllegalArgumentException.class);
		
		expectedExcecao.expectMessage("negativos proibidos [-1 -2 -3 -4 -2147483648]");
		CalculadoraString.add("1, -2, 3, -4,-1,2 -3\n-4, -1, -2 -2147483648");
	}
	/**
	 * Quando recebe alguns numeros negativos separados por delimitador definido
	 *  deve lancar uma excecao e uma mensagem bem definido com todos numeros 
	 *  negativos passados.
	 *  Passo 5
	 */
	@Test
	public void QuandoRecebeNumerosNegativosSeparadosPorDelimitadorDefinidoGeraExcecaoComMessagemComTodosOsNumerosNegativos(){
		expectedExcecao.expect(IllegalArgumentException.class);
		expectedExcecao.expectMessage("negativos proibidos [-1 -2 -3 -4]");
		CalculadoraString.add("//[.]\n.1, -2. 3., -4,.-1,2. -3\n-4. -1. -2");
	}
	
	/**
	 * Numeros maiores que 1000 sao ignorados
	 * Passo 6
	 */
	@Test
	public void NumerosMaioresQue1000SaoIgnorados() {
		assertEquals(0, CalculadoraString.add("2147483648"));
		assertEquals(0, CalculadoraString.add("1001"));
		assertEquals(10, CalculadoraString.add("1 1001 2 1001 3 1001 4 "));
		assertEquals(1010, CalculadoraString.add("//[-]\n-1-1001-2-2147483648-3-2019,1001, 1000 \n -4"));
	}
	
	/**
	 * Verifica se a soma esta correta quando define delimitador com tamanho indefinido.
	 * Passo 7
	 */
	@Test
	public void QuandoPassaNumerosComDelimitadorDefinidoDeTamanhosVariadosRetornaSomaDosNumeros() {
		assertEquals(10, CalculadoraString.add("//[%%%%%]\n1%%%%%2%%%%%3%%%%%4"));
		assertFalse(1 == CalculadoraString.add("//[%%%%%]\n1%%%%%2%%%%%3%%%%%4"));
		assertEquals(10, CalculadoraString.add("//[;;;;;]\n1;;;;;2;;;;;3;;;;;4;;;;;"));
		assertEquals(10, CalculadoraString.add("//[@@]\n@@1@@2@@3@@4@@"));
		assertEquals(10, CalculadoraString.add("//[;;;;;;;;;;;;;;;;]\n10"));
		assertEquals(10, CalculadoraString.add("//[::::::::::::::::]\n::::::::::::::::10::::::::::::::::"));
		assertEquals(0, CalculadoraString.add("//[;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;]\n0"));
		assertEquals(10, CalculadoraString.add("//[@@@@@@@@@@@@@@@@@@]\n0@@@@@@@@@@@@@@@@@@010@@@@@@@@@@@@@@@@@@0"));
		assertEquals(10, CalculadoraString.add("//[--]\n--1--2--3--4"));
		assertEquals(10, CalculadoraString.add("//[aaaaa]\naaaaa1aaaaa2aaaaa3aaaaa4"));
		assertEquals(10, CalculadoraString.add("//[BBB]\nBBB1BBB2BBB3BBB4BBB"));
		assertEquals(10, CalculadoraString.add("//[	   ]\n	   1	   2	   3 4	"));
	}
	// TODO FAZ O TESTE DE UM NÚMERO NEGATIVO GRANDE
}
