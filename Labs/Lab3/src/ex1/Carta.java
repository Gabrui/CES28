/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * Classe Pai de todas os tipos de carta.
 *
 * COMENTÁRIO:
 * 
 * A classe Carta funciona como um builder de strings, fornencendo
 * o contrato para a construção da string com os métodos cabecalho(),
 * corpo(), conclusao() e assinatura().
 * 
 * Ela também atua como o Diretor, uma vez que também leva consigo o
 * método de construção modelo(). Essa mistura de Diretor e Builder 
 * se deu pelo fato de string ser um tipo primitivo, e a classe Diretor
 * seria anêmica, com apenas um método que faz uma concatenação de strings.
 * 
 * Assim o Builder também é o Diretor, para esse tipo primitivo String, o
 * que não viola o princípio da Single Responsability, uma vez que saber montar
 * Strings já é uma responsabilidade da Carta.
 * 
 * As cartas podem ser facilmente extendidas e já veêm com muitos métodos default.
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
	
	public final String modelo() {
		return cabecalho() + corpo() + conclusao() + assinatura();
	}

	
}
