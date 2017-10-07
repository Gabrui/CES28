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
	
	public String modeloPortugues(String mensagem) {
		return cabecarioPortugues() + corpoPortugues(mensagem) + despedida() + assinaturaPortugues();
	}
	protected String cabecarioPortugues() {
		return _remetente.getEndereco()+ ", "
				+_idioma.data(_data)
				+ "\n\n";
	}
	protected String corpoPortugues(String mensagem) {
		return _idioma.vocativo() + " " + _destinatario.getNome()+", " +"\n\n"
				+ mensagem +"\n\n";
	}
	protected String despedida(){
		return _idioma.despedida() +"\n\n";
	}
	protected String assinaturaPortugues() {
		return  _remetente.getNome()+"\n\n";
	}
}
