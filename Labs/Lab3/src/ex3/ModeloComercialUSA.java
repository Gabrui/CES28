/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo da carta comercial Americano.
 */
public class ModeloComercialUSA extends ModeloComercial{
	
	@Override
	public String cabecalho(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return idioma.data(data) + "\n\n" + remetente.getNome() + "\n" +
				remetente.getEndereco(idioma) + "\n\n" + destinatario.getNome() + "\n" +
				destinatario.getEndereco(idioma) + "\n\n\n";
	}
	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		return "\n\n"+remetente.getNome() +"\n\n            __________________\n            "
				+ "\n            " + remetente.getFone(idioma)
				+ "\n            email: " + remetente.getEmail();
	}
}
