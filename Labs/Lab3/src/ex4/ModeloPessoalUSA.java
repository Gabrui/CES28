/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo da carta pessoal americana.
 */
public class ModeloPessoalUSA extends ModeloPessoal{
	
	@Override
	public String cabecario(Pessoa remetente, Pessoa destinatario,Data data, Idioma idioma) {
		return  idioma.data(data) + "\n"
				+remetente.getNome()+", "+remetente.getEndereco(idioma) + "."
				+ "\n\n";
	}
}
