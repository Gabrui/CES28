/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex1;

/**
 * Classe que contém informações pessoais
 *
 */
public class Pessoa {

	private final String _nome;
	private final int _idade;
	private String _email;
	private Endereco _endereco;
	private String _fone;
	
	public Pessoa(String nome,int idade,Endereco endereco,String email, String fone) {
		_nome = nome;
		_idade = idade;
		_endereco = endereco;
		_email = email;
		_fone = fone;
	}
	public String getNome() {
		return _nome;
	}
	public int getIdade() {
		return _idade;
	}
	public String getEndereco() {
		return _endereco.getEndereco();
	}
	public String getEmail() {
		return _email;
	}
	public String getFone() {
		return _fone;
	}
}

