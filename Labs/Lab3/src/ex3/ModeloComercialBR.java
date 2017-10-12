/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 08/10/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo comercial brasileiro
 */
public class ModeloComercialBR extends ModeloComercial{

	@Override
	public String cabecalho(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getNomeEmpresa() + "\n"
				+ remetente.getDepartamento() + "\n"
				+ remetente.getEndereco(idioma) + ", "
				+ idioma.data(data)
				+ "\n"
				+ "Assunto: " + "\n\n";
	}
	@Override
	public String assinatura(Pessoa remetente, Idioma idioma) {
		return  remetente.getNome() + "\n\n"
				+remetente.getDepartamento() + "\n" + remetente.getFone(idioma);
	}
}
