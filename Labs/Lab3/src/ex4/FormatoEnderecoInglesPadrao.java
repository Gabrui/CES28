/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 09/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o formato do endereco em ingles padrao.
 */
public class FormatoEnderecoInglesPadrao extends FormatoEndereco{

	@Override
	public String endereco(String rua, String cidade, String estado, String pais) {
		return rua +", "+cidade 
		+ "   "+estado +" "+ pais ;
	}

}
