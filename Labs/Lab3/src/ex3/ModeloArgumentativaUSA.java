/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe abstrata que representa o modelo da carta argumentativa americano.
 */
public class ModeloArgumentativaUSA extends ModeloArgumentativa{

	@Override
	public String cabecalho(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getFone(idioma)+ ", " +idioma.data(data) 
		+ " - " + remetente.getEndereco(idioma) + "\n\n";
	}

	@Override
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.vocativo()+ " " + destinatario.getNome() + ", "
				+ "\n\n"
				;
	}

	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		return remetente.getNome() + ", " + remetente.getEmail();
	}

}
