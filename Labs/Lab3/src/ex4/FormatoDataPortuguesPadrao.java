/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 09/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o formato da data em portugues padrao.
 */
public class FormatoDataPortuguesPadrao extends FormatoData{

	@Override
	public String data(String dia, String mes, String ano) {
		// Formato da Data: "dia de mes de ano"
		return dia + " de " + mes + " de " + ano;
	}

}