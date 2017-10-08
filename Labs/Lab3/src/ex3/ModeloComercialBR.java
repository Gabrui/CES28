/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Representa o modelo comercial brasileiro
 */
public class ModeloComercialBR {

	public String cabecarioPortugues(Pessoa remetente, Pessoa destinatario, Data data, Idioma idioma) {
		return remetente.getNomeEmpresa() + "\n"
				+ remetente.getDepartamento() + "\n"
				+ remetente.getEndereco(idioma) + ", "
				+ idioma.data(data)
				+ "\n"
				+ "Assunto: " + "\n\n";
	}
	public String assinaturaPortugues(Pessoa remetente, Idioma idioma) {
		return  remetente.getNome() + "\n\n"
				+remetente.getDepartamento() + "\n" + remetente.getFone(idioma);
	}
}
