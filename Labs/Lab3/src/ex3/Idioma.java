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
	
	public abstract String despedida();
	public abstract String vocativo();
	public abstract String pronome();
	
	public abstract String data(Data data);
	public abstract String endereco(Endereco end);
	public abstract String fone(Telefone fone);
}
