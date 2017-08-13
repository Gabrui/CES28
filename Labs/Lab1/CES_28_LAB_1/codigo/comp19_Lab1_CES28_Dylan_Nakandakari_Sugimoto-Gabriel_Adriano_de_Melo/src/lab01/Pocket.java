/**
 * LAB-1 CES-28
 * Data: 01/08/2017
 * @encoding UTF-8
 * @author - Dylan Nakandakari Sugimoto
 * @author - Gabriel Adriano de Melo
 * 
 * Esse pacote contem as classes principais, isto é, implementadas
 */
package lab01;


/**
 * PASSO 10 - MÉTODO ADD RETORNA MONEY OU MONEYBAG
 * Interface comum a operações com dinheiro.
 * Possui interfaces dos passos 10 e 11.
 */
public interface Pocket {
	/**
	 * Retorna um Pocket resultado da soma.
	 * Se o resultado for um Money, retorna um novo money
	 * Se o resultado for uma MoneyBag, retorna a mesma MoneyBag modificada.
	 * Um MoneyBag pode conter dinheiros sem valor.
	 * @param money Dinheiro a ser adicionado
	 * @return Um novo dinheiro ou mala resultado da operação
	 */
	public Pocket add(Money money);
	/**
	 * Retorna o valor do Pocket
	 * Se for um Money, retorna seu valor próprio
	 * PASSO 11:
	 * Se for uma MoneyBag, retorna o seu valor total em reais.
	 * @return O valor do dinheiro, ou a conversão total das moedas para reais
	 */
	public int getAmount();
}
