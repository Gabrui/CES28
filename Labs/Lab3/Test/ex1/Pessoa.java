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
	private Endereco _endereco;
	
	public Pessoa(String nome,int idade,Endereco endereco) {
		_nome = nome;
		_idade = idade;
		_endereco = endereco;
	}
	public String getNome() {
		return _nome;
	}
	public int getIdade() {
		return _idade;
	}
	public String getEndereco() {
		return _endereco.getRua()+_endereco.getCidade()+_endereco.getEstado()+_endereco.getPais();
	}
}
