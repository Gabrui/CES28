/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * Esta classe é o builder da classe Carta.
 *
 */
public class builderCarta {
	
	//Declarando variaveis privadas
	private String _cabecario;
	private String _corpo;
	private String _conclusao;
	private String _assinatura;
	private String _modelo;
	//Fim da declaração de variaveis privadas
	
	//construtor da classe
	public builderCarta(String modelo) {
		this._modelo = modelo;
	}
	public void buildCabecario(String cabecario) {
		this._cabecario = cabecario;
	}
	public void buildCorpo(String corpo) {
		this._corpo = corpo;
	}
	public void buildConclusao(String conclusao) {
		this._conclusao = conclusao;
	}
	public void buildAssinatura(String assinatura) {
		this._assinatura = assinatura;
	}
	public Carta buildCarta() {
		
		return new CartaComercial(_cabecario,_corpo,_conclusao,_assinatura);
	}
}
