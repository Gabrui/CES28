/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex2;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Ingles guarda alguns parametros da carta em ingles
 */
public class Ingles extends Idioma {

	public Ingles() {
		
		_despedida = "Gratefully";
		_vocativo = "Dear";
		_PronomeTratamento = "Mr.";
	}
	@Override
	public String data(Data data) {
		return data.getDia() + " / " + data.getMes() + " / " + data.getAno();
	}
}
