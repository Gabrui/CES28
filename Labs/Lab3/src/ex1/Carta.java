/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * Classe Pai de todas os tipos de carta.
 *
 */
public abstract class Carta {
	
	//declarando variaveis privadas
	protected final String _cabecario;
	protected final String _corpo;
	protected final String _conclusao;
	protected final String _assinatura;
	//Fim da declaração de variaveis privadas
	
	protected Carta(String cabecario,String corpo,String conclusao,String assinatura) {
		_cabecario = cabecario;
		_corpo = corpo;
		_conclusao = conclusao;
		_assinatura = assinatura;
		
	}
	
}
