/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex2;

/**
 * 
 * Classe para representar a carta do tipo Pessoal
 */
public class CartaPessoal extends Carta{
	
	
	
	public CartaPessoal(Pessoa remetente, Pessoa destinatario,Data data, Idioma idioma) {
		super(remetente,destinatario,data, idioma);
	}
	

	@Override
	protected String cabecalho() {
		return  _destinatario.getEndereco(_idioma) + "\n" +_data.toString() + "\n\n";
	}
	
}
