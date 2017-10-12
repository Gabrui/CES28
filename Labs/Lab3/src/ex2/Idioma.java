/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex2;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 * Representacao  da traducao dos campos da Carta.
 * 
 * COMENTÁRIO:
 * 
 * Essa classe é responsável pela formação de cada campo da carta.
 * 
 * É extremamente fácil de ser extendida, bastando o programador criar
 * uma nova classe que a extenda ou uma de suas subclasses, sem a necessidade
 * de se alterar nenhuma outra classe.
 * 
 * Ou seja, o código está aberto para extensão mas fechado para modificação, 
 * digamos, se fosse necessário alterar o código interno de alguma classe concreta
 * já existente.
 * 
 * Uma atenção especial foi dada também ao fato de não existirem classes anêmicas, 
 * com apenas um método, o que é um mal-cheiro, dessa forma as traduções dos campos
 * foram agrupados nessa classe idioma, em vez de existirem várias classes pequenas
 * para cada campo.
 * 
 * Assim, nesse primeiro momento, utilizou-se apenas uma simples herança de idiomas
 * e injeção de dependência em carta para se obter o requisito de cartas em diferentes
 * idiomas, pois esse foi a forma mais simples para extensão encontrada. Em uma 
 * AbstractFactory convencional o usuário precisaria extender tanto os produtos (campos)
 * quanto a factory (Idioma), o que seria mais trabalhoso, e ainda poderiam existir
 * classes anêmicas.
 * 
 */
public abstract class Idioma {
	
	public abstract String despedida();
	public abstract String vocativo();
	public abstract String pronome();
	
	public String data(Data data) {
		return data.getMes() + "/" + data.getDia() + "/" + data.getAno();
	}
	
	public String endereco(Endereco end) {
		return end.getRua()   +", "+ end.getCidade() + ", " + end.getEstado() + ", " + end.getPais();
	}
	
	public String fone(Telefone fone) {
		return "+"+ fone.getDDI()+ " ("+fone.getCC()+")"+" ("+fone.getLC()+") "+fone.getTel(5);
	}
}
