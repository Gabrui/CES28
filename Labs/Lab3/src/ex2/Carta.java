/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex2;

/**
 * Classe Pai de todas os tipos de carta.
 *
 * COMENTÁRIO:
 * => (ANTERIOR)
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
 * => MUDANÇAS:
 * 
 * A carta agora também recebe um Idioma na sua construção. Esse idioma é responsável
 * por formatar cada campo da forma solicitada. Ele é facilmente extendível. VER Idioma.
 */
public abstract class Carta {

	protected Pessoa _remetente;
	protected Pessoa _destinatario;
	protected Data _data;
	protected Idioma _idioma;
	
	public Carta(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		_remetente = remetente;
		_destinatario = destinatario;
		_data = data;
		_idioma = idioma;
	}
	
	protected String cabecalho() {
		return _remetente.getNome() + "\n" + _remetente.getEndereco(_idioma) + "\n\n"
				+ _idioma.data(_data) + "\n\n"
				+ _destinatario.getNome() + "\n" + _destinatario.getEndereco(_idioma)
				+ "\n\n\n";
	}
	
	protected String corpo() {
		return _idioma.pronome()+ " " + _destinatario.getNome() + ",\n\n\n";
	}
	
	protected String conclusao() {
		return _idioma.despedida() + ",\n";
	}
	
	protected String assinatura() {
		return _remetente.getNome();
	}
	
	public String modelo() {
		return cabecalho() + corpo() + conclusao() + assinatura();
	}

	
}
