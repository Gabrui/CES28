/**
 *  @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 */
package bancoDados;

/**
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 *
 */
public interface Imposto {

	//Imposto é um elemento abstrato para podermos usar o polimorfismo
	//no BD. Assim podem existir diferentes implementacoes do Imposto que sao usados
	//pelo BD e definidos a tempo de execucao. DP Strategy. (Requisito 9)
	public int taxar(ProdutoServico analisado);
}
