/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;
/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe abstrata que representa o modelo da carta argumentativa brasileira.
 */
public class ModeloArgumentativaBR extends ModeloArgumentativa{

	@Override
	public String cabecalho(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getEndereco(idioma) + ", "+
				idioma.data(data)
				+ "\n\n";
	}

	@Override
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.vocativo() + " " +idioma.pronome() + " "
				+ destinatario.getNome()+", " +"\n\n";
	}

	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		return  remetente.getNome()+"\n\n";
	}

}
