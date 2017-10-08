/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 30/09/2017
 */
package ex3;

/**
 * Classe para representar o formato da carta argumentativa
 *
 */
public class CartaArgumentativa extends Carta {
	
	public CartaArgumentativa(Pessoa remetente, Pessoa destinatario,Data data, Idioma idioma) {
		super(remetente,destinatario,data,idioma);
	}
	
	public String modelo(String intro, String desen,String con) {
		if(_idioma instanceof Portugues) {
			return modeloPortugues(intro,desen,con);
		}
		else if(_idioma instanceof Ingles){
			return modeloIngles(intro,desen,con);
		}
		else {
			return "Idioma da Carta inexistente.";
		}
	}
	private String modeloPortugues(String intro,String desenvolvimento,String conclusao) {
		return cabecarioPortugues() + corpoPortugues(intro,desenvolvimento,conclusao) + despedida() + assinaturaPortugues();
	}
	private String modeloIngles(String intro,String desenvolvimento,String conclusao) {
		return cabecarioIngles() + corpoIngles(intro, desenvolvimento,conclusao) + despedida() + assinaturaIngles();
	}
	private String cabecarioIngles() {
		return _remetente.getFone(_idioma)+ ", " +_idioma.data(_data) 
				+ " - " + _remetente.getEndereco(_idioma) + "\n\n";
	}
	protected String cabecarioPortugues() {
		return _remetente.getEndereco(_idioma) + ", "+
				_idioma.data(_data)
				+ "\n\n";
	}
	private String corpoIngles(String intro, String desen, String con) {
		return _idioma.vocativo()+ " " + _destinatario.getNome() + ", "
				+ "\n\n"
				+ intro+"\n"
				+desen + "\n"
				+con+"\n\n";
	}
	private String assinaturaIngles() {
		return _remetente.getNome() + ", " + _remetente.getEmail();
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
