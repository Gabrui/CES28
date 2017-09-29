/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * Esta classe é o builder da classe Carta.
 *
 */
public class builderCarta {
	
	//Declarando variaveis privadas
	private String _cabecario;
	private String _corpo;
	private String _conclusao;
	private String _assinatura;
	private String _modelo;
	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Data _data;
	//Fim da declaração de variaveis privadas
	
	//construtor da classe
	public builderCarta(Pessoa remetente, Pessoa destinatario, Data data) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
	}
	public CartaComercial buildCartaComercial() {
		
		
		return new CartaComercial(_remetente, _destinatario,_data);
		
	}
	public CartaPessoal buildCartaPessoa() {
		
		return new CartaPessoal(_remetente, _destinatario, _data);
	}
}
