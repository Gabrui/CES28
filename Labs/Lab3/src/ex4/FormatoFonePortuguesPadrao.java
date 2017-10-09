/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 09/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representao formato do telefone em portugues padrao.
 *
 */
public class FormatoFonePortuguesPadrao extends FormatoFone{

	@Override
	public String fone(String DDI, String cc, String lc, String tel) {
		// cc: codigo do pais / lc: codigo local.
		return DDI+" - "+cc+" - "+"("+lc+") "+tel;
	}

}
