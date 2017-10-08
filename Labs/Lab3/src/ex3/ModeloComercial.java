/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo da carta comercial.
 */
public abstract class ModeloComercial extends Modelo{

	@Override
	public String cabecario(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getNome() + ", " + remetente.getEndereco(idioma) + "\n\n"
				+ idioma.data(data) + "\n\n"
				+ destinatario.getNome() + ", " + destinatario.getEndereco(idioma)
				+ "\n\n\n";
	}

	@Override
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.vocativo() + destinatario.getNome()+": " +"\n\n"
			   +"\n\n";
	}

	@Override
	public String despedida(Idioma idioma) {
		// Idioma trata de traduzir a despedida
		return idioma.despedida() +",\n\n";
	}

	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		// TODO Auto-generated method stub
		return  remetente.getNome() + "\n\n"
				+remetente.getDepartamento();
	}

	
	
}
