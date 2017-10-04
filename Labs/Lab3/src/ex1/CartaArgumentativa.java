/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 30/09/2017
 */
package ex1;

/**
 * Classe para representar o formato da carta argumentativa
 *
 */
public class CartaArgumentativa extends Carta {
	
	public CartaArgumentativa(Pessoa remetente, Pessoa destinatario,Data data) {
		super(remetente,destinatario,data);
	}
	public String modeloPortugues(String vocativo,String intro,String desenvolvimento,String conclusao,String despedida) {
		return cabecarioPortugues() + corpoPortugues(vocativo,intro,desenvolvimento,conclusao) + despedida(despedida) + assinaturaPortugues();
	}
	protected String cabecarioPortugues() {
		return _enderecoRemetente.toString() + ", "+_data.getDataPortugues(" de ") + "\n\n";
	}
	protected String corpoPortugues(String vocativo, String introducao, String desenvolvimento, String conclusao) {
		return vocativo + _destinatario.getNome()+", " +"\n\n"
				+ introducao + "\n"
				+ desenvolvimento + "\n"
				+ conclusao +"\n\n";
	}
	protected String despedida(String despedida){
		return despedida +"\n\n";
	}
	protected String assinaturaPortugues() {
		return  _remetente.getNome()+"\n\n";
	}
}
