/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex4e5;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe abstrata que representa o modelo da carta Pessoal.
 */
public abstract class ModeloPessoal extends Modelo{

	@Override
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.vocativo() + " " + destinatario.getNome()+", " +"\n\n"
				+ "\n\n";
	}

	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		return  remetente.getNome()+"\n\n";
	}

	
}
