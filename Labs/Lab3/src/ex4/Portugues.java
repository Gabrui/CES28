/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Portugues guarda alguns parametros da carta em portugues
 */
public class Portugues extends Idioma {
	
	public static final Portugues INSTANCE = new Portugues();
		
	private Portugues() {
		super();
	}

	protected Portugues (PortuguesBuilder b) {
		super(b);
	}
	
	public static class PortuguesBuilder extends Builder {
		public PortuguesBuilder() {
				super(new Portugues());
		}
	}

	@Override
	protected String despedidaFormato() {
		return "Atensiosamente";
	}

	@Override
	protected String vocativoFormato() {
		return "Caro";
	}

	@Override
	protected String pronomeFormato() {
		return "Senhor";
	}

	@Override
	protected String dataFormato(String dia, String mes, String ano) {
		// Formato da Data: "dia de mes de ano"
		return dia + " de " + mes + " de " + ano;
	}

	@Override
	protected String enderecoFormato(String rua, String cidade, String estado, String pais) {
		return rua +", "+ cidade +", "+estado+" - " + pais;
	}

	@Override
	protected String foneFormato(String DDI, String cc, String lc, String tel) {
		// cc: codigo do pais / lc: codigo local.
		return DDI+" - "+cc+" - "+"("+lc+") "+tel;
	}
	
}
