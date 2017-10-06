/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * Classe Pai de todas os tipos de carta.
 *
 */
public abstract class Carta {

	protected Pessoa _remetente;
	protected Pessoa _destinatario;
	protected Data _data;
	
	public Carta(Pessoa remetente, Pessoa destinatario, Data data) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
	}

	
}
