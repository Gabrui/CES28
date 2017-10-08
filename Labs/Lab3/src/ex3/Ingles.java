/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Ingles guarda alguns parametros da carta em ingles
 */
public class Ingles extends Idioma {

	@Override
	public String despedida() {
		return "Gratefully";
	}
	
	@Override
	public String vocativo() {
		return "Dear";
	}
	
	@Override
	public String pronome() {
		return "Mr.";
	}
	
	@Override
	public String endereco(Endereco end) {
		return end.rua() +", "+end.cidade() + "   "+end.estado() +" "+ end.pais() ;
	}
	@Override
	public String fone(Telefone fone) {
		return "+" +"("+ fone.DDI() + fone.cc() + fone.lc()+")" + fone.tel();
	}
}
