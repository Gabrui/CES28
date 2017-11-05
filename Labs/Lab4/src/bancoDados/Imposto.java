/**
 *  @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 */
package bancoDados;

import java.util.HashMap;

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
	//Requisito 18. O overload no metodo taxar permite que o imposto tenha total
	//liberdade para dedicir qual a regra aplicar em cada nó da árvore.
	//E todo imposto tem acesso a todos os nós da árvore, por causa da implementacao 
	//do metodo accept que há na NotaFiscalMutavel,ItemVenda,ProdutoServico,ProdutoServicoComposto
	//Produto e Servico.
	public void taxar(ProdutoServico analisado);
	public void taxar(Produto analisado);
	public void taxar(NotaFiscalMutavel notaFiscalMutavel);
	public void taxar(ItemVenda itemVenda);
	public void taxar(Servico analisado);
	public void taxar(ProdutoServicoComposto analisado);
	public HashMap<String, Integer> getImpostoCalculado();
	public int getImpostoTotal();
	public String id();
	public int getRealimentacao();
	public void setRealimentacao(int dado);
}
