/**
 * LAB-3 / CES - 28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex4;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 *
 */
public class Telefone {

	private String _DDI; //
	private String _cc; //Country Code
	private String _lc; //Local Code
	private String _tel; // Telefone
	
	public Telefone(int DDI, int cc, int lc, int tel) {
		
		_DDI = String.valueOf(DDI);
		_cc = String.valueOf(cc);
		_lc = String.valueOf(lc);
		String telefone = String.valueOf(tel);
		_tel = telefone.substring(0 ,telefone.length() - 5) + "-" +  telefone.substring(telefone.length() - 5);
	}
	public String DDI() {
		return _DDI;
	}
	public String cc() {
		return _cc;
	}
	public String lc() {
		return _lc;
	}
	public String tel() {
		return _tel;
	}
}
