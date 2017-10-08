/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto
 * Classe abstrata que representa o modelo da carta.
 */
public abstract class Modelo {
	
	protected Idioma _idioma;
	
	public abstract String cabecario(Pessoa remetente, Pessoa destinatario,Data data, Idioma idioma);
	public abstract String corpo();
	public abstract String despedida(Idioma idioma);
	public abstract String assinatura(Pessoa remetente,Idioma idioma);
}
