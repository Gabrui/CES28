/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Ingles guarda alguns parametros da carta em ingles
 */
public class Ingles extends Idioma {

	public Ingles() {
		
		_despedida = new FormatoDespedidaInglesPadrao();
		_vocativo = new FormatoVocativoInglesPadrao();
		_pronome = new FormatoPronomeInglesPadrao();
		_end = new FormatoEnderecoInglesPadrao();
		_fone = new FormatoFoneInglesPadrao();
		_data = new FormatoDataInglesPadrao();
		
	}
}
