/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 09/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representao formato do telefone ingles padrao.
 *
 */
public class FormatoFoneInglesPadrao extends FormatoFone{

	@Override
	public String fone(String DDI, String cc, String lc, String tel) {
		return "+" +"("+ DDI +cc + lc+")" + tel;
	}

}
