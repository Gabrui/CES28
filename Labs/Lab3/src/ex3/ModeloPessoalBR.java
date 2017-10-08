/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;


/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe abstrata que representa o modelo da carta pessoal brasileira.
 */
public class ModeloPessoalBR extends ModeloPessoal{

	@Override
	public String cabecario(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getEndereco(idioma) + ", "
				+idioma.data(data)
				+ "\n\n";
	}
}
