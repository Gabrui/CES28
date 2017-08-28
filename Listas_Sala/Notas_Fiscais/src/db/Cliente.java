package db;

public class Cliente {
	private String CPF;
	private String Nome;

	Cliente(String CPF, String Nome) {
		this.CPF = CPF;
		this.Nome = Nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getNome() {
		return Nome;
	}

}
