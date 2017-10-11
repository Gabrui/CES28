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
	
	private Ingles(Builder b) {
		super(b);
	}

	@Override
	protected Idioma rebuild(Builder b) {
		return new Ingles(b);
	}
	
	public static class InglesBuilder extends Builder {
		public InglesBuilder() {
			super(Ingles.INSTANCE);
		}
	}

	@Override
	public String despedidaFormato() {
		return "Gratefully";
	}

	@Override
	protected String vocativoFormato() {
		return "Dear";
	}

	@Override
	protected String pronomeFormato() {
		return "Mr.";
	}

	@Override
	protected String dataFormato(String dia, String mes, String ano) {
		// Date's Format: Month/Day/Year
				return mes+"/"+dia+"/"+ano;
	}

	@Override
	protected String enderecoFormato(String rua, String cidade, String estado, String pais) {
		return rua +", "+cidade 
				+ "   "+estado +" "+ pais ;
	}

	@Override
	protected String foneFormato(String DDI, String cc, String lc, String tel) {
		// cc: codigo do pais / lc: codigo local.
				return DDI+" - "+cc+" - "+"("+lc+") "+tel;
	}
}
