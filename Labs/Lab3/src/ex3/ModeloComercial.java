/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo da carta comercial.
 */
public class ModeloComercial extends Modelo{

	@Override
	public String cabecario(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String corpo(Idioma idioma, Pessoa destinatario) {
		return idioma.vocativo() + destinatario.getNome()+": " +"\n\n"
			   +"\n\n";
	}

	@Override
	public String despedida(Idioma idioma) {
		// Idioma trata de traduzir a despedida
		return _idioma.despedida() +",\n\n";
	}

	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		// TODO Auto-generated method stub
		return  remetente.getNome() + "\n\n"
				+remetente.getDepartamento();
	}

	
	
}
