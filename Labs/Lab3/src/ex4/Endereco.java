package ex4;

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
	
	public String getRua() {
		return _rua;
	}
	
	public String getCidade() {
		return _cidade;
	}
	
	public String getEstado() {
		return _estado;
	}
	
	public String getPais() {
		return _pais;
	}
	
}
