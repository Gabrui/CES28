/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Portugues guarda alguns parametros da carta em portugues
 */
public class Portugues extends Idioma {
	
public Portugues() {
		
		_despedida = new FormatoDespedidaPortuguesPadrao();
		_vocativo = new FormatoVocativoPortuguesPadrao();
		_pronome = new FormatoPronomePortuguesPadrao();
		_end = new FormatoEnderecoPortuguesPadrao();
		_fone = new FormatoFonePortuguesPadrao();
		_data = new FormatoDataPortuguesPadrao();
		
	}
	
}
