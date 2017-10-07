/**
 * @author Dylan N. Sugimoto e Gabriel Adriano de Melo
 * Data da criação: 29/09/2017
 */
package ex2;

/**
 * Classe que contém informações pessoais
 *
 */
public class Pessoa {

	private String _nome;
	private int _idade;
	private String _email;
	private Endereco _endereco;
	private String _fone;
	private String _departamento;
	private String _emprego;
	private String _nomeEmpresa;
	
	private Pessoa(PessoaBuilder builder) {
		_nome = builder.nome;
		_idade = builder.idade;
		_email = builder.email;
		_endereco = builder.endereco;
		_fone = builder.fone;
		_departamento = builder.departamento;
		_emprego = builder.emprego;
		_nomeEmpresa = builder.nomeEmpresa;
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
	public void setEmprego(String emprego) {
		_emprego = emprego;
	}
	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}
	public void setEmpresa(String empresa) {
		_nomeEmpresa = empresa;
	}
	public String getDepartamento() {
		return _departamento;
	}
	public String getEmprego() {
		return _emprego;
	}
	public String getNomeEmpresa() {
		return _nomeEmpresa;
	}
	
	public static class PessoaBuilder {
		
		private String nome;
		private int idade = 0;
		private String email = "";
		private Endereco endereco;
		private String fone = "";
		private String departamento = "";
		private String emprego = "";
		private String nomeEmpresa = "";
		
		public PessoaBuilder() {
			this.nome = "Anônimo";
			this.endereco = new Endereco("", "", "", "");
		}
		
		public PessoaBuilder(String nome, Endereco endereco) {
			this.nome = nome;
			this.endereco = endereco;
		}
		
		public Pessoa build() {
			return null;
		}
		
		public PessoaBuilder idade(int idade) {
			this.idade = idade;
			return this;
		}
		
		public PessoaBuilder idade(String email) {
			this.email = email;
			return this;
		}
		
		public PessoaBuilder fone(String fone) {
			this.fone = fone;
			return this;
		}
		
		public PessoaBuilder departamento(String departamento) {
			this.departamento = departamento;
			return this;
		}
		
		public PessoaBuilder emprego(String emprego) {
			this.emprego = emprego;
			return this;
		}
		
		public PessoaBuilder nomeEmpresa(String nomeEmpresa) {
			this.nomeEmpresa = nomeEmpresa;
			return this;
		}
	}
}

