/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe abstrata que representa o modelo da carta.
 * 
 * Ele agora é o Builder propriamente dito
 */
public abstract class Modelo {
	
	public abstract String cabecario(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma);
	public abstract String corpo(Idioma idioma, Pessoa destinatario);
	
	public String despedida(Idioma idioma) {
		return idioma.despedida() +",\n\n";
	}
	
	public abstract String assinatura(Pessoa remetente, Idioma idioma);
}
