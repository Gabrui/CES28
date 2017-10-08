/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 * Representacao  da traducao de alguns parametros da Carta.
 */
public abstract class Idioma {
	
	protected String _despedida;
	protected String _vocativo;
	protected String _PronomeTratamento;
	
	public String despedida() {
		return _despedida;
	}
	public String vocativo() {
		return _vocativo;
	}
	public String pronome() {
		return _PronomeTratamento;
	}
	public abstract String data(Data data);
	public abstract String endereco(Endereco end);
	public abstract String fone(Telefone fone);
}
