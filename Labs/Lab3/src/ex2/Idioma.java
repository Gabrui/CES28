/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex2;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 * Representacao  da traducao de alguns parametros da Carta.
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
		return "+"+ fone.DDI()+ " ("+fone.cc()+") "+" ("+fone.lc()+") "+fone.tel();
	}
}
