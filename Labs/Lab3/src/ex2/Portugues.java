/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex2;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Portugues guarda alguns parametros da carta em portugues
 */
public class Portugues extends Idioma {

	public Portugues() {
		
		_despedida = "Atenciosamente";
		_vocativo = "Caro";
		_PronomeTratamento = "Senhor";
	}
	@Override
	public String data(Data data) {
		return data.getDia() + " de " + data.getMes() + " de " + data.getAno();
	}
}
