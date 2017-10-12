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
	
	public String cabecalho(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getNome() + "\n" + remetente.getEndereco(idioma) + "\n\n"
				+ idioma.data(data) + "\n\n"
				+ destinatario.getNome() + "\n" + destinatario.getEndereco(idioma)
				+ "\n\n\n";
	}
	
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.pronome()+ " " + destinatario.getNome() + ",\n\n\n";
	}
	
	public String conclusao(Idioma idioma) {
		return idioma.despedida() +",\n";
	}
	
	public String assinatura(Pessoa remetente, Idioma idioma) {
		return remetente.getNome();
	}
}
