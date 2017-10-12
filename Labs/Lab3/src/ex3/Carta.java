/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex3;

/**
 * 
 * A classe Carta agora é o Director do Builder Modelo
 * 
 */
public class Carta {

	private Pessoa _remetente;
	private Pessoa _destinatario;
	private Data _data;
	private Idioma _idioma;
	private Modelo _modelo;
	
	public Carta(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma, Modelo modelo) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		_idioma = idioma;
		_modelo = modelo;
	}
	
	private String cabecalho() {
		return _modelo.cabecario(_remetente, _destinatario, _data, _idioma);
	}
	
	private String corpo() {
		return _modelo.corpo(_idioma, _destinatario);
	}
	
	private String conclusao() {
		return _modelo.despedida(_idioma);
	}
	
	private String assinatura() {
		return _modelo.assinatura(_remetente, _idioma);
	}
	
	public String lerCarta() {
		return cabecalho() + corpo() + conclusao() + assinatura();
	}

	
}
