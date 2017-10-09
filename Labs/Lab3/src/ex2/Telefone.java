/**
 * LAB-3 / CES - 28
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criacao: 07/10/2017
 */
package ex2;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 *
 */
public class Telefone {
	private String _DDI; //
	private String _cc;  // Country Code
	private String _lc;  // Local Code
	private String _tel; // Telefone
	
	public Telefone(int DDI, int cc, int lc, int tel) {
		_DDI = String.valueOf(DDI);
		_cc = String.valueOf(cc);
		_lc = String.valueOf(lc);
		_tel = String.valueOf(tel);
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
	
	public String tel(int posicaoSeparador) {
		return _tel.substring(0, _tel.length() - posicaoSeparador) + 
				"-" +  _tel.substring(_tel.length() - posicaoSeparador);
	}
}
