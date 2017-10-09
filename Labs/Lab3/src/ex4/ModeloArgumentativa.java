/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Classe abstrata que representa o modelo da carta argumentativa.
 */
public abstract class ModeloArgumentativa extends Modelo{

	@Override
	public String despedida(Idioma idioma) {
		return idioma.despedida() +"\n\n";
	}

	
}
