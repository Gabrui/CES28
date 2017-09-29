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
	public void buildCabecarioComercial(String nomeDaEmpresaEmissorra,String departamentoEmissor,String assunto,String vocativo) {
		this._cabecario = nomeDaEmpresaEmissorra + "\n"
				+ departamentoEmissor +"\n"
				+ assunto +"\n\n"
				+ vocativo + "\n\n";
	}
	public void buildCorpo(String corpo) {
		this._corpo = corpo;
	}
	public void buildDespedida(String despedida) {
		this._conclusao = despedida+"\n\n";
	}
	public void buildAssinaturaComercial(Pessoa remetente) {
		this._assinatura = remetente.getNome()+"\n\n"
						   + remetente.getEmprego()+remetente.getDepartamento()+"\n";
	}
	public Carta buildCarta() {
		
		if( _modelo.toLowerCase() == "comercial") {
			return new CartaComercial(_cabecario,_corpo,_conclusao,_assinatura);
		}
	}
}
