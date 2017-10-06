/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * 
 * Classe para representar a carta do tipo Pessoal
 */
public class CartaPessoal extends Carta{
	
	public CartaPessoal(Pessoa remetente, Pessoa destinatario, Data data) {
		super(remetente, destinatario, data);
	}
	
	@Override
	protected String cabecalho() {
		return  _destinatario.getEndereco() + "\n" +_data.toString() + "\n\n";
	}
	
}
