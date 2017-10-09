/**
 * LAB-3 / CES-28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da Criacao: 07/10/2017
 * Classe Ingles guarda alguns parametros da carta em ingles
 */
public class Ingles extends Idioma {
	
	public static final Ingles INSTANCE = new Ingles();
	
	private Ingles() {
		super();
	}

	protected Ingles (InglesBuilder b) {
		super(b);
	}
	
	// Ingles.InglesBuilder().assinatura(Portugues.getInstance())).build()
	public static class InglesBuilder extends Builder {
		public InglesBuilder() {
			super(new Ingles());
		}
	}

	@Override
	public String despedidaFormato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String vocativoFormato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String pronomeFormato() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String dataFormato(String dia, String mes, String ano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String enderecoFormato(String rua, String cidade, String estado, String pais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String foneFormato(String DDI, String cc, String lc, String tel) {
		// TODO Auto-generated method stub
		return null;
	}
}
