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
	private String _vocativo = "Caro";
	
	
	public Carta(Pessoa remetente, Pessoa destinatario, Data data) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
	}
	
	protected final void setVocativo(String vocativo) {
		_vocativo = vocativo;
	}
	
	protected String cabecalho() {
		return _remetente.getNome() + "\n" + _remetente.getEndereco() + "\n\n"
				+ _data.toString() + "\n\n"
				+ _destinatario.getNome() + "\n" + _destinatario.getEndereco()
				+ "\n\n\n";
	}
	
	protected String corpo() {
		return _vocativo + " " + _destinatario.getNome() + ",\n\n\n";
	}
	
	protected String conclusao() {
		return "Atensiosamente,\n";
	}
	
	protected String assinatura() {
		return _remetente.getNome();
	}
	
	public String modelo() {
		return cabecalho() + corpo() + conclusao() + assinatura();
	}

	
}
