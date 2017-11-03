/**
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 */
package bancoDados;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Dylan N. Sugimoto, Gabriel Adriano de Melo e André Marcello Soto Riva Figueira.
 *
 * Classe que guarda estados para calculo do imposto.
 */
public abstract class  DataObject {

	protected String _estado;
	protected List<Imposto> _regraAplicavel;
	protected DataObject(){
		_regraAplicavel = new LinkedList<>();
		loadRegraAplicavel();
	}
	abstract protected void loadRegraAplicavel();
	abstract protected void storeEstado();
}
