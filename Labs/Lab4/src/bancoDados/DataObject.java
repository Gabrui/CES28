/**
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 */
package bancoDados;

import java.util.List;

/**
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 *
 * Classe que guarda estados para calculo do imposto.
 */
/**
 * Requisito 19.
 * O construtor de cada implementação do DataObject
 * deve criar uma lista de impostos que usam em comum certos
 * conjunto de dados historicos, e deve criar essas implementacoes
 * de Imposto e adicioná-los na lista.
 * Quando BD precisar de usar uma dessas implementações de Imposto
 * ele pede para o DataObject por meio de numero (NA) e pega pelo
 * metodo imposto da implementação do DataObject, que já pode tomar
 * o cuidado de atualizar o imposto com os dados historicos necessários
 * para realizar a taxação, ou seja, executar o updateImposto da implementação
 * do DataObject que pode ser complexa.
 * Assim, a implementação do DataObject pode conter atributos para guardar os dados
 * historicos, e métodos de atualização desses dados adequados usados pelo BD, para
 * depois realimentar o Imposto com esses dados no updateImposto. 
 * E como é uma interface podemos ter diversas lógicas de realimentação de dados.
 * */
public interface DataObject {

	public List<Imposto> getAllImposto();
	public Imposto imposto(String NA);
	public void updateImposto(Imposto imp);
}
