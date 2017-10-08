package ex3;

/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 * Classe para guardar enderecos
 */
public class Endereco {
	
	private String _rua;
	private String _cidade;
	private String _estado;
	private String _pais;
	
	public Endereco(String rua,String cidade,String estado,String pais) {
		
		_rua = rua;
		_cidade = cidade;
		_estado = estado;
		_pais = pais;
		
	}
	public Endereco copiar() {
		return new Endereco(_rua,_cidade,_estado,_pais);
	}
	public String rua() {
		return _rua;
	}
	public String cidade() {
		return _cidade;
	}
	public String estado() {
		return _estado;
	}
	public String pais() {
		return _pais;
	}
	
}
