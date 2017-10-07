/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 30/09/2017
 */
package ex2;

/**
 * Classe para representar o formato da carta argumentativa
 *
 */
public class CartaArgumentativa extends Carta {
	
	public CartaArgumentativa(Pessoa remetente, Pessoa destinatario,Data data, Idioma idioma) {
		super(remetente,destinatario,data,idioma);
	}
	
	public String modeloPortugues(String intro,String desenvolvimento,String conclusao) {
		return cabecarioPortugues() + corpoPortugues(intro,desenvolvimento,conclusao) + despedida() + assinaturaPortugues();
	}
	
	protected String cabecarioPortugues() {
		return _remetente.getEndereco() + ", "+
				_idioma.data(_data)
				+ "\n\n";
	}
	
	protected String corpoPortugues(String introducao, String desenvolvimento, String conclusao) {
		return _idioma.vocativo() + " " +_idioma.pronome() + " " + _destinatario.getNome()+", " +"\n\n"
				+ introducao + "\n"
				+ desenvolvimento + "\n"
				+ conclusao +"\n\n";
	}
	
	protected String despedida(){
		return _idioma.despedida() +"\n\n";
	}
	
	protected String assinaturaPortugues() {
		return  _remetente.getNome()+"\n\n";
	}
}
