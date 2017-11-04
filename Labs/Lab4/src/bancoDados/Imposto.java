/**
 *  @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 */
package bancoDados;

import notaFiscal.ItemVenda;
import notaFiscal.NotaFiscalMutavel;

/**
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 *
 */
public interface Imposto {

	//Imposto é um elemento abstrato para podermos usar o polimorfismo
	//no BD. Assim podem existir diferentes implementacoes do Imposto que sao usados
	//pelo BD e definidos a tempo de execucao. DP Strategy. (Requisito 9)
	//DP Visitor Requisito 10. taxar é o visit
	public void taxar(ProdutoServico analisado);
	public void taxar(Produto analisado);
	public void taxar(NotaFiscalMutavel notaFiscalMutavel);
	public void taxar(ItemVenda itemVenda);
	public void taxar(Servico analisado);
}
