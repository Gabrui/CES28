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
	//Fim da declaração de variaveis privadas
	
	//construtor da classe
	public builderCarta(String modelo) {
		this._modelo = modelo;
	}
	public Carta buildCarta(Pessoa remetente, Pessoa destinatario,Data data) {
		
		if( _modelo.toLowerCase() == "comercial") {
			return new CartaComercial(remetente, destinatario,data);
		}
	}
}