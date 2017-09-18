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
import java.util.Random;

/**
 * 
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo
 * Esta Classe testa a classe CalculadoraString.
 * 
 */
public class TesteCalculadoraSimples {
	private Random GeneratorRandomInt;
	private int RandomInt1000;
	@Before
	public void setUp() {
		GeneratorRandomInt = new Random();
		RandomInt1000 = GeneratorRandomInt.nextInt(1001);
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
		assertEquals(RandomInt1000, CalculadoraString.add(String.valueOf(RandomInt1000)));
	}
	
	/**
	 * Passo 1 e teste do Passo 2
	 */
	@Test
	public void SomaNumerosSeparadosPorVirgula() {
		assertEquals(3, CalculadoraString.add("1,2"));
		assertEquals(10, CalculadoraString.add("1,2,3,4"));
		int total =0;
		String Operandos ="";
		for(int i =0; i<100;i++) {
			
			total += RandomInt1000;
			Operandos += String.valueOf(RandomInt1000) + ",";
			assertEquals(total, CalculadoraString.add(Operandos));
			RandomInt1000 = GeneratorRandomInt.nextInt(1001);
		}
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
		int total =0;
		int RandomIndexDelimiter=GeneratorRandomInt.nextInt(3);
		String[] delimitadorPadrao = new String[]{" ","\n",","} ;
		String Operandos ="";
		for(int i =0; i<100;i++) {
			
			total += RandomInt1000;
			Operandos += String.valueOf(RandomInt1000) + delimitadorPadrao[RandomIndexDelimiter];
			assertEquals(total, CalculadoraString.add(Operandos));
			RandomInt1000 = GeneratorRandomInt.nextInt(1001);
			RandomIndexDelimiter=GeneratorRandomInt.nextInt(3);
		}
	}
	/**
	 * Marcadores Padroes: " " ou  "\n" ou  ",".
	 * Passo 3
	 */
	@Test
	public void RetornaZeroQuandoRecebeApenasMarcadoresPadroes() {
		
		//Testes simples com os delimitadores padroes
		assertEquals(0, CalculadoraString.add("\n\n\n"));
		assertEquals(0, CalculadoraString.add(",,,"));
		assertEquals(0, CalculadoraString.add("   "));
		
		//Testar com uma cadeia de combinacao aleatoria com os delimitadores padroes
		String[] delimitadorPadrao = new String[]{" ","\n",","} ;
		int RandomIndexDelimiter=GeneratorRandomInt.nextInt(3);
		String Operandos ="";
		for(int i=0; i<RandomInt1000+10;i++) {
			Operandos += delimitadorPadrao[RandomIndexDelimiter];
			assertEquals(0, CalculadoraString.add(Operandos));
			RandomIndexDelimiter = GeneratorRandomInt.nextInt(3);
		}
		
	}
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Testando se o metodo add permite definir delimitadores, ou seja,
	 * se quando definimos um delimitador nao eh gerado um erro e retorna zero
	 * Passo 4
	 */
	@Test
	public void VerificaSeAddPermiteDefinirDelimitador() {
		for(int i=0;i<128;i++) {
			if(i != 91 && i != 93 && (i<48 || i>57)) {
				assertEquals(0, CalculadoraString.add("//["+ (char) i +"]\n"));
			}
			//System.out.println(i + ": " + (char) i); //imprime a tabela ASCII
		}
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
		assertEquals(10, CalculadoraString.add("//[\n]\n1\n2\n3\n4\n"));
		assertEquals(10, CalculadoraString.add("//[@]\n@1@2@3@4@"));
		assertEquals(10, CalculadoraString.add("//[;]\n10"));
		assertEquals(10, CalculadoraString.add("//[:]\n:10:"));
		assertEquals(0, CalculadoraString.add("//[;]\n0"));
		assertEquals(10, CalculadoraString.add("//[@]\n0@010@0"));
		assertEquals(10, CalculadoraString.add("//[-]\n-1-2-3-4"));
		assertEquals(10, CalculadoraString.add("//[a]\na1a2a3a4"));
		assertEquals(10, CalculadoraString.add("//[B]\nB1B2B3B4B"));
		assertEquals(10, CalculadoraString.add("//[	]\n	1	2	3	4	"));
		
		//Testar com uma cadeia de combinacao de numero aleatorios
		// e com todos os caracteres da tabela ascii
		
		int total =0;
		String Operandos ="";
		for(int IndexDelimitador=1;IndexDelimitador<128;IndexDelimitador++) {
			total =0;
			Operandos = "//["+(char) IndexDelimitador+"]\n";
			if(IndexDelimitador != 91 && IndexDelimitador != 93 && (IndexDelimitador<48 || IndexDelimitador>57)) {
				for(int i =0; i<100;i++) {
					
					total += RandomInt1000;
					Operandos += String.valueOf(RandomInt1000) + (char) IndexDelimitador;
					assertEquals(total, CalculadoraString.add(Operandos));
					RandomInt1000 = GeneratorRandomInt.nextInt(1001);
				}
			}
		}
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
		assertEquals(10, CalculadoraString.add("//[*]\n *1**2***3****4 **********************************"));
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
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Com barra a mais
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorForaDoFormatoComBarraMaisGeraExcecao() {
		CalculadoraString.add("///[%]\\\n");
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
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * colchete em ordem trocada
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorComColcheteEmOrdemTrocadaGeraExcecao() {
		CalculadoraString.add("//]%[\n");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * inicio trocado com o fim
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorInicioTrocadoComFimGeraExcecao() {
		CalculadoraString.add("\n]%[//");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * trocado ]/\n com [delimtiador
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirDelimitadorComOrdemTrocadaComFinalGeraExcecao() {
		CalculadoraString.add("//]\n[%");
	}
	
	
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido usar delimitador definido de tamanho menor.
	 * Passo 4 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeUsarDelimitadorDeTamanhoMenorDoQueDefinidoGeraExcecao() {
		CalculadoraString.add("//[-----]\n -----1 ,----2,---3 --4 -0-\n-- , \n -,-");
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
	
	/**
	 * Forma para definir Delimitador: "//[delimiter]\n"
	 * Nao eh permitido usar numero como delimitador padrao. 
	 * Especificacao definida na terceira pergunta do FAQ
	 * Passo 4
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirNumeroComoDelimitadorGeraExcecao() {
		CalculadoraString.add("//[9123999945609995789990999909990]\n");
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
		
		expectedExcecao.expectMessage("negativos proibidos [-2 -4 -1 -3 -4 -1 -2 -2147483648 -999999999999999999]");
		// TODO Não é para ter espaço separando sinal de - do número
		System.out.println(CalculadoraString.add("-0, 1, -2, 3, -4,-1,2 -3\n-4, -1, -2 -2147483648 -00000000000 -999999999999999999"));
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
		expectedExcecao.expectMessage("negativos proibidos [-2 -4 -1 -3 -4 -1 -2]");
		// TODO sem espaço, já perdi muito tempo com esses espaços no inicio da string, achando que o erro era no codigo
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
		// TODO não é para ter espaço em branco iniciando a string, isso não está certo
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
		assertEquals(10, CalculadoraString.add("//[	   ]\n	   1	   2	   3 4"));
	}
	
	/**
	 * Verifica se a soma esta correta quando usa multiplos delimitador definido com os padroes
	 * Passo 8
	 */
	@Test
	public void QuandoPassaNumerosComMultiplosDelimitadoresDefinidosEComDelimitadorPadraoRetornaSomaDosNumeros() {
		assertEquals(10, CalculadoraString.add("//[%][.]\n   .1%2,.3\n%4.\n"));
		assertFalse(1 == CalculadoraString.add("//[%][.]\n   .1%2,%3\n.4\n"));
		assertEquals(10, CalculadoraString.add("//[;][(][)]\n(1)  (2);(3)\n(4);"));
		assertEquals(10, CalculadoraString.add("//[@][\\][t]\n@1 \\t2\n t3 @ \\4@\n , "));
		assertEquals(10, CalculadoraString.add("//[;][£][°]\n  £\n10°,,,,"));
		assertEquals(10, CalculadoraString.add("//[:][+]\n : ,\n+10+\n, : "));
		assertEquals(0, CalculadoraString.add("//[;][&]\n&0&"));
		assertEquals(10, CalculadoraString.add("//[@][¬]\n  ¬0 @ ¬010,¬0\n"));
		assertEquals(10, CalculadoraString.add("//[-][|]\n |-1|,|-2| |-3|\n |-4| -,\n"));
		assertEquals(10, CalculadoraString.add("//[%][!]\n  % %\n %,\n \n%, \n%, 1!%2!,3!\n4!\n!"));
		assertEquals(10, CalculadoraString.add("//[a][=]\n a= 1\n a= 2, a= ,3, ,a=, \n,a= 4 "));
		assertEquals(10, CalculadoraString.add("//[B][\\][d]\n B \\d1\\d, B, ,\\d2\\d, ,B, ,\\d3\\d,\\\n B,d\nd ,\\d4\n, ,B, "));//testando com tab
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter][delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Com lixo entre as definicoes
	 * Passo 8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirMultiplosDelimitadoresComLixoEntreAsDefinicoesGeraExcecao() {
		CalculadoraString.add("//[^@]l1X0\n@M³¹°[\t]\n");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter][delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Com espaco em branco entre as definicoes
	 * Passo 8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirMultiplosDelimitadoresComEspacoEmBrancoEntreAsDefinicoesGeraExcecao() {
		CalculadoraString.add("//[^@] [\t]\n");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter][delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Faltando um [
	 * Passo 8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirMultiplosDelimitadoresFaltandoColcheteEsquerdoGeraExcecao() {
		CalculadoraString.add("//[^@]\t]\n");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter][delimiter]\n"
	 * Nao eh permitido definir delimitador que nao esteja no formato. 
	 * Faltando um ]
	 * Passo 8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirMultiplosDelimitadoresFaltandoColcheteDireitoGeraExcecao() {
		CalculadoraString.add("//[^@[\t]\n");
	}
	
	/**
	 * Forma para definir Delimitador: "//[delimiter][delimiter]\n"
	 * Nao eh permitido definir delimitador Vazio.
	 * Passo 8
	 */
	@Test(expected = IllegalArgumentException.class)
	public void SeDefinirMultiplosDelimitadoresEmQueUmEhVazioGeraExcecao() {
		CalculadoraString.add("//[^@][\t][]\n");
	}
	
	@Test
	public void RetornaZeroParaNumerosQueDariaOverflow() {
		assertEquals(0, CalculadoraString.transformaStringEmNumero("9870979765876987698754992"));
		assertEquals(0, CalculadoraString.transformaStringEmNumero("0000000000000000000000000"));
		assertEquals(0, CalculadoraString.transformaStringEmNumero("-000000000000000000000000"));
		assertEquals(0, CalculadoraString.transformaStringEmNumero("98767576"));
		assertEquals(0, CalculadoraString.transformaStringEmNumero("9898"));
	}
	
	@Test
	public void RetornaNumeroPequenoParaSupostoNumeroGrande() {
		assertEquals(10, CalculadoraString.transformaStringEmNumero("0000000000000000000000000010"));
		assertEquals(10, CalculadoraString.transformaStringEmNumero("00010"));
		assertEquals(10, CalculadoraString.transformaStringEmNumero("00000010"));
		assertEquals(10, CalculadoraString.transformaStringEmNumero("0000010"));
		assertEquals(10, CalculadoraString.transformaStringEmNumero("000000000000000000010"));
		// TODO Esse não é o método add
		assertEquals(0, CalculadoraString.transformaStringEmNumero("-00000000000000000000000000000"));
		assertEquals(0, CalculadoraString.transformaStringEmNumero("-0000000000000000000000000000000000000000000"));
	}
	
	/**
	 * Verifica se a soma esta correta quando usa multiplos delimitador definido de 
	 * tamanho indefinido com os padroes
	 * Passo 9
	 */
	@Test
	public void QuandoPassaNumerosComMultiplosDelimitadoresDefinidosDeTamanhoIndefinidoEComDelimitadorPadraoRetornaSomaDosNumeros() {
		assertEquals(10, CalculadoraString.add("//[%%%][...]\n   ...1%%%2,...3\n%%%4...\n"));
		assertFalse(1 == CalculadoraString.add("//[%][...]\n  ...1%2,%3\n...4\n"));
		assertEquals(0, CalculadoraString.add("//[;;;;][((((][))))))))))))))]\n"));
		assertEquals(10, CalculadoraString.add("//[@@@@@@][\\\\][ttttt]\n \\\\\\\\ \n@@@@@@1 \\\\\\\\ttttt2\n ttttt3 @@@@@@ \\\\\\\\4@@@@@@\n , "));
		// TODO quantidade errada de caracteres
		assertEquals(10, CalculadoraString.add("//[aaaaaa][======]\n aaaaaa====== 1\n aaaaaa====== 2, aaaaaa====== ,3, ,aaaaaa======, \n,aaaaaa====== 4 "));
		assertEquals(10, CalculadoraString.add("//[BBBB][\n][d]\n BBBB d1d, BBBB, ,d2\nd, ,BBBB, ,d3d,\n BBBB,d\nd ,\nd4\n, ,BBBB, "));
	}
	
	/**
	 * Verifica se eh possivel decompor em delimitadores definidos.
	 * Passo 9
	 */
	@Test
	public void QuandoUmDelimitadorEstaContidoNoOutro() {
		assertEquals(10, CalculadoraString.add("//[aa][aaa]\n5aaaaa5"));
		assertEquals(10, CalculadoraString.add("//[abc][abcab]\n abcab5 abcabcabcababcabcabcab 5"));
	}
}
